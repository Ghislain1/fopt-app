package fopt.klausur.lin.aufgabe7;

import java.io.*;
import java.net.Socket;

public class Channel implements Runnable {
    private Socket client;
    private BufferedReader reader;
    private BufferedWriter writer;

    public Channel(Socket client) {
        this.client = client;
        try {
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
           release();
        }
    }

    private String recieve(){
        String datas ="";
        try {
            datas = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datas;
    }

    private void release(){
        if(reader!=null){
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(writer!=null){
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(client!=null){
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        String recieveMessages = recieve();
        try {
            writer.append("server ---> " + recieveMessages);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
