package fopt.pp2020.lin.tag3.aufgabe1;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ParallelStatischUPDServer
{

    public static void main(String[] args)
    {
        boolean isRunning = true;
        ThreadPoolExecutor pool =
                new ThreadPoolExecutor(3, 3,
                        0L, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<Runnable>());
        while (isRunning)
        {

            try (UDPSocket udpSocket = new UDPSocket(1250))
            {
                System.out.println("Server>> wartet!! ..");
                pool.execute(new StatischUDPSocketThread(udpSocket,20));
            }
            catch (Exception socketException)
            {
                isRunning = false;
                socketException.printStackTrace();
            }

        }
    }

}
