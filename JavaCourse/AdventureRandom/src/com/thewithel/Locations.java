package com.thewithel;

import java.io.*;
import java.util.*;

//THIS CLASS IS SINGLETON WHICH MEANS THAT ONLY ONE INSTANCE OF THIS CLASS CAN BE CREATED
public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    //way of how this works right now: zapisuje do pliku liczbe lokacji, a nastepnie "wskaźnik" bajtowy na to gdzie
    //zaczynają sie lokacje. Nastepnie w miejscu gdzie zaczynaja sie te lokacje zapisuje po kolei ID lokacji, opis, wyjścia
    //+ ich kierunki, potem dzięki temu IntexRecord przypisuje te indexy do tych lokacji. W static block wczytuje po prostu te
    //pierwsza czesc bytow ktora przypina te indexy do tych danych lokacji

    //this is just main method to show us how try block with resources works
    public static void main(String[] args) throws IOException {

        //RandomAccesFile class cant write and read objects :(
        try (RandomAccessFile rao = new RandomAccessFile("locations_rand.dat", "rwd")){
            rao.writeInt(locations.size());
            int indexSize = locations.size() * 3 * Integer.BYTES;
            int locationStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES);
            rao.writeInt(locationStart);

            long indexStart = rao.getFilePointer();

            int startPointer = locationStart;
            rao.seek(startPointer);

            for(Location location : locations.values()){
                rao.writeInt(location.getLocationID());
                rao.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                for(String direction : location.getExits().keySet()){
                   if(!direction.equalsIgnoreCase("Q")){
                       builder.append(direction);
                       builder.append(",");
                       builder.append(location.getExits().get(direction));
                       builder.append(",");
                   }
                }

                rao.writeUTF(builder.toString());

                IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer));
                index.put(location.getLocationID(), record);

                startPointer = (int) rao.getFilePointer();
            }

            rao.seek(indexStart);
            for(Integer locationID : index.keySet()){
                rao.writeInt(locationID);
                rao.writeInt(index.get(locationID).getStartByte());
                rao.writeInt(index.get(locationID).getLength());
            }

        }
    }

    //1. This first four bytes will contain the number of locations (bytes 0-3)
    //2. The next four bytes will contain the start iffset of the locations secion (bytes 4-7)
    //3. The next secion of the file will contain the index (the index is 1692 bytes long. It will start at byte 8 and end at byte 1699
    //4. The final section of the file will contain the location records (the data). It will start at byte 1700


    static {
        try {
            ra = new RandomAccessFile("locations_rand.dat", "rwd");
            int numLocations = ra.readInt();
            long locationStartPoint = ra.readInt();

            while(ra.getFilePointer() < locationStartPoint){
                int locationId = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationId, record);
            }

        } catch (IOException e){
            System.out.println("IOException in static initializer: " +e.getMessage());
        }
    }

    public Location getLocation(int locationID) throws IOException{

        IndexRecord record = index.get(locationID);
        ra.seek(record.getStartByte());
        int id = ra.readInt();
        String description = ra.readUTF();
        String exits = ra.readUTF();
        String[] exitPart = exits.split(",");

        Location location = new Location(locationID, description, null);

        if(locationID != 0) {
            for(int i=0; i<exitPart.length; i++) {
                System.out.println("exitPart = "+exitPart[i]);
                System.out.println("exitPart[+1] = "+exitPart[i+1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }

        return location;
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }

    public void close() throws IOException {
        ra.close();
    }
}