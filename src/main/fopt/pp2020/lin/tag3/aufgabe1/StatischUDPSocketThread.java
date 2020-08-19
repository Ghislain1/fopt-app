package fopt.pp2020.lin.tag3.aufgabe1;

import java.io.IOException;

public class StatischUDPSocketThread implements Runnable {

    private UDPSocket udpSocket;
    private int maxByte;

    public StatischUDPSocketThread(UDPSocket udpSocket, int maxByte) {
        this.udpSocket = udpSocket;
        this.maxByte = maxByte;
    }

    @Override
    public void run() {
        try {
            String request =  this.udpSocket.receive(maxByte);
            udpSocket.reply("reply from server " + request);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
