package fopt.klausur.ghis.ss2019;

import java.util.Random;

import fopt.buch.abschn55.TCPSocket;
import fopt.buch.abschn55.TCPSocketImpl;

public class TCPSocketClient
{

    public static void main(String[] args)
    {
        try (TCPSocket tcpSocket = new TCPSocketImpl("localhost", 7777))
        {
            int numberOfLines = Integer.parseInt(args[0]);
            for (int i = 1; i <= numberOfLines; i++)
            {
                tcpSocket.sendLine(" Message Nr.  " + i);
                sleepRandom();

            }
        }
        catch (Exception ex)
        {

        }
        System.out.println("************** Client SAYS BYE **********************");
    }

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

}
