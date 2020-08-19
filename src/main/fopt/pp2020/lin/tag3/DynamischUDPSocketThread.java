package fopt.pp2020.lin.tag3;

import java.io.IOException;

public class DynamischUDPSocketThread implements Runnable {

    private int maxByte;
    private int port;

    public DynamischUDPSocketThread(int maxByte, int port) {

        this.maxByte = maxByte;
        this.port = port;
    }

    @Override
    public void run() {
        boolean isRunning = true;
        while (isRunning)
        {

            try (UDPSocket udpSocket = new UDPSocket(port))
            {
                System.out.println("Server>> wartet!! ..");
                String request = udpSocket.receive(maxByte);
                udpSocket.reply("reply from server " + request + "???");
            }
            catch (Exception socketException)
            {
                isRunning = false;
                socketException.printStackTrace();
            }

        }

    }
}
