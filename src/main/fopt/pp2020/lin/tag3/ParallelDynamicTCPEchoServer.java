package fopt.pp2020.lin.tag3;

import java.net.ServerSocket;

public class ParallelDynamicTCPEchoServer
{

    public static void main(String[] args)
    {
        try (ServerSocket serverSocket = new ServerSocket(1250))
        {
            int numberOfRunner = 1000;
            int indexRunner = 0;
            while (indexRunner < numberOfRunner)
            {
                indexRunner++;
                try
                {
                    new Slave(serverSocket.accept());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

    }

}
