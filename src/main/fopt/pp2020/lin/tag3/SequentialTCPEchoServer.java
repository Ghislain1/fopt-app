package fopt.pp2020.lin.tag3;

import fopt.buch.abschn55.TCPSocket;
import fopt.buch.abschn55.TCPSocketImpl;

import java.net.ServerSocket;
import java.net.Socket;

public class SequentialTCPEchoServer
{
    public static void main(String[] args)
    {
        int numberOfRunner = 1000;
        int index = 0;

        while (index < numberOfRunner)
        {
            index++;
            try (ServerSocket serverSocket = new ServerSocket(1250))
            {
                try (Socket socket = serverSocket.accept())
                {
                    TCPSocket tcpSocket = new TCPSocketImpl(socket);
                    String msg = tcpSocket.receiveLine();
                    int msgInterger = Integer.parseInt(msg);
                    try
                    {
                        // Sekundenschlaf
                        Thread.sleep(msgInterger * 1000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    // PONG msg
                    tcpSocket.sendLine(msg);
                }
                catch (Exception e)
                {

                }
            }
            catch (Exception e)
            {

            }
        }
    }
}
