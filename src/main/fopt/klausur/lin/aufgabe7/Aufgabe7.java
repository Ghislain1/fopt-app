package fopt.klausur.lin.aufgabe7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Aufgabe7 {
    public static void main(String[] args) {
        System.out.println("----server start----");
        boolean isRunning = true;
        ServerSocket socket =null;
        Socket client = null;
        try {
            socket = new ServerSocket(7777);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(isRunning) {
            try {
                client = socket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("------client build up a connection--------");

            new Thread(new Channel(client)).start();

        }
    }
}
