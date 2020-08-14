package fopt.buch.abschn53;

import java.net.InetAddress;
import java.util.Random;

public class UDPClient
{
    private static void sleepRandom()
    {
        int timeToSleep = (int) (new Random().nextDouble() * 1000);

        try
        {
            Thread.sleep(timeToSleep);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    // TODO@Ghis: Warun UDP kann die daten verlieren?
    public static void main(String[] args)
    {
        if (args.length < 2)
        {
            System.out.println("IP and Port der Server ist: 127.0.0.1 1250");

        }
        // send some
        try (UDPSocket udpSocket = new UDPSocket())
        {
            udpSocket.setSoTimeout(1000 * 10);
            InetAddress inetAddress = InetAddress.getByName(args[0]);
            int port = Integer.parseInt(args[1]);
            udpSocket.send("reset", inetAddress, port);

            String responseFromServer = udpSocket.receive(20);
            System.out.println("Client>> Counter= " + responseFromServer);

            for (int i = 0; i < 235; i++)
            {
                sleepRandom();
                udpSocket.send("increment", inetAddress, port);

                System.out.println("Client>> Counter= " + udpSocket.receive(20));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
