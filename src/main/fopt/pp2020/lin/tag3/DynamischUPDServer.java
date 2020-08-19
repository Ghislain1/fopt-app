package fopt.pp2020.lin.tag3;

import java.net.SocketException;

public class DynamischUPDServer
{


    public static void main(String[] args)
    {
        UDPSocket udpSocket;
        boolean isRunning = true;

        while (isRunning)
        {
            // foreach.
            new Thread(new DynamischUDPSocketThread(20, 2005)).start();

        }
    }

}
