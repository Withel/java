package com.matthew;//IMPORT TO TAKI ZAMIENNIC INCLUDE
import java.util.ArrayList;

    public class GroceryList {

        private ArrayList<String> groceryList = new ArrayList<String>();

        public void addGroceryItem(String item){
            groceryList.add(item);
        }

        public ArrayList<String> getGroceryList() {
            return groceryList;
        }

        //WYŚWIETLANIE WSZYSTKICH ELEMENTÓW LISTY (list.size() zwraca liczbę elementów w liście
        public void printGroceryList(){
            System.out.println("You have " +groceryList.size() + " items in your Grocery List");
            for (int i=0; i<groceryList.size(); i++){
                System.out.println((i+1)+". "+groceryList.get(i));
            }
        }

        //MODYFIKOWANIE ELEMENTY LISTY
        private void modifyGroceryItem(int position, String newItem){
            groceryList.set(position, newItem);
            System.out.println("grocery item " + (position+1)+"has been modified.");
        }

        //OVERLOADING FUNCTION
        public void modifyGroceryItem(String currentItem, String newItem){
            int position = findItem(currentItem);
            if(position >= 0){
                modifyGroceryItem(position, newItem);
            }
        }

        //USUWANIE ELEMENTU LISTY
        private void removeGroceryItem(int position){
            groceryList.remove(position);
        }

        public void removeGroceryItem(String item){
            int position = findItem(item);
            if (position >= 0){
                removeGroceryItem(position);
            }
        }

        //PRZESZUKIWANIE LISTY I ZWRÓCENIE ZAWARTOŚCI JEŚLI JEST

//        public String findItem(String searchItem){
////            boolean exists = groceryList.contains(searchItem); //ZWRACA TRUE JEŻELI ISTNIEJE
//            int position = groceryList.indexOf(searchItem);  //ZWRACA INDEX ZNALEZIONEGO ELEMENTU
//            if(position >=0){
//                return groceryList.get(position);
//        }
//        return null;

        private int findItem(String searchItem){
            return groceryList.indexOf(searchItem);
    }
        public boolean onFile(String searchItem){
            int position = findItem(searchItem);
            if(position >= 0) return true;
            else return false;
        }
}
