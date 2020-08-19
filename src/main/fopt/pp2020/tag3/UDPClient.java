package fopt.pp2020.tag3;

import java.net.InetAddress;

public class UDPClient
{
    private static final int TIMEOUT = 10000; // 10 seconds

    public static void main(String args[])
    {
        int serverPort = 4100;
        String serverAddrString = "localhost";
        int maxCount = 50;
        System.out.println(" ServerName= " + serverAddrString + "Server Port " + serverPort);
        // create datagram socket
        try (UDPSocket udpSocket = new UDPSocket())
        {
            udpSocket.setTimeout(TIMEOUT);
            // get inet addr of server
            InetAddress serverAddr = InetAddress.getByName(serverAddrString);

            udpSocket.send("hallo", serverAddr, serverPort);
            String reply = null;

            long startTime = System.currentTimeMillis();
            // receive reply
            try
            {
                reply = udpSocket.receive(20);
                System.out.println(reply);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            // initialize start time

            // display statistics
            long stopTime = System.currentTimeMillis();
            long duration = stopTime - startTime;
            System.out.println("Gesamtzeit = " + duration + " msecs");

            System.out.println("Durchschnittszeit = " + ((duration) / (float) maxCount) + " msecs");

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        System.out.println("DatagramSocket wurde geschlossen");
    }
}
