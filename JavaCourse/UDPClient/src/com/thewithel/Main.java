package com.thewithel;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    try{
            InetAddress addres = InetAddress.getLocalHost();    //getByName()
            DatagramSocket datagramSocket = new DatagramSocket();

            Scanner scanner = new Scanner(System.in);
            String echoString;

            do{
                System.out.println("Enter string to be echoed: ");
                echoString = scanner.nextLine();

                byte[] buffer = echoString.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
                        addres, 5000);
                datagramSocket.send(packet);

                byte[] buffer2 = new byte[50];
                packet = new DatagramPacket(buffer2, buffer2.length);
                datagramSocket.receive(packet);
                System.out.println("Text recieved is: " + new String(buffer2, 0,
                        packet.getLength()));

            } while(!echoString.equals("exit"));

        } catch (SocketTimeoutException e){
            System.out.println(e.getMessage());
        } catch(IOException e){
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
