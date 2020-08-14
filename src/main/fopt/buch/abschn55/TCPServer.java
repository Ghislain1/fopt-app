package fopt.buch.abschn55;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServer
{
    static int MAX_SERVER_LISTENER = 58;

    private static void sleepRandom()
    {
        int timeToSleep = (int) (new Random().nextDouble() * 5000);

        try
        {
            Thread.sleep(timeToSleep);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        int numberOfClientCounter = 0;
        int model = 0;

        try (ServerSocket serverSocket = new ServerSocket(4200))
        {
            while (numberOfClientCounter < MAX_SERVER_LISTENER)
            {
                System.out.println("Server>> listenning!! ");
                Socket socket = serverSocket.accept();
                numberOfClientCounter++;
                System.out.println("Server>> Client Nr. " + numberOfClientCounter + " - " + socket.getInetAddress().getHostAddress() + ":" + socket.getPort());
                try (TCPSocket tcpSocket = new TCPSocketImpl(socket))
                {
                    while (true)
                    {
                        // Fake works for server
                        sleepRandom();
                        String msg = tcpSocket.receiveLine();
                        if (msg == null)
                        {
                            break;

                        }
                        System.out.println("Server>> CMD " + msg);
                        if (msg.trim().equals("reset"))
                        {
                            model = 0;
                        }
                        else if (msg.trim().equals("increment"))
                        {
                            model++;
                        }

                        // generate response;
                        String res = String.valueOf(model);
                        tcpSocket.sendLine(res);
                    }

                }

            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
}
