package fopt.pp2020.tag3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DynamicUDPServer
{
    public static void main(String[] args)
    {
        // create socket
        try (DatagramSocket datagramSocket = new DatagramSocket(4100))
        {
            // wait for request packets
            System.out.println("Server wartet auf Kunden");
            // execute client requests
            while (true)
            {
                // receive request
                DatagramPacket p = receive(datagramSocket, 500);

                // Request auslagern
                new UDPSlave(datagramSocket, p, p.getLength());
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        System.out.println("DatagramSocket wurde geschlossen");
    }

    private static DatagramPacket receive(DatagramSocket datagramSocket, int maxBytes)
    {
        byte[] inBuffer = new byte[maxBytes];
        DatagramPacket inPacket = new DatagramPacket(inBuffer, inBuffer.length);
        try
        {
            datagramSocket.receive(inPacket);
        }
        catch (IOException e)
        {

            e.printStackTrace();
        }
        return inPacket;

    }
}