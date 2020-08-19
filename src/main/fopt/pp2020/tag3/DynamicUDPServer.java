package fopt.pp2020.tag3;

public class DynamicUDPServer
{
    public static void main(String[] args)
    {
        // create socket
        try (UDPSocket udpSocket = new UDPSocket(4100))
        {
            // wait for request packets
            System.out.println("Server wartet auf Kunden");
            // execute client requests
            while (true)
            {
                // receive request
                String request = udpSocket.receive(20);

                // Request auslagern
                new UDPSlave(udpSocket, request);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        System.out.println("DatagramSocket wurde geschlossen");
    }
}