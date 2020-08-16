package fopt.pp2020.tag1;

import java.util.Random;

public class BoundedCounterDemo
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

    public static void main(String[] args)
    {
        BoundedCounter boundedCounter = new BoundedCounter(0, 10);

        // Thread - Leser
        Thread leserThread = new Thread(() ->
        {
            while (true)
            {
                System.out.println("LesenThread > Counter = " + boundedCounter.get());
                try
                {
                    // 5 s Takt lesen
                    Thread.sleep(1000 * 5);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

        });
        leserThread.start();

        // Down-Thread
        Thread downThread = new Thread(() ->
        {
            while (true)
            {
                boundedCounter.down();
                sleepRandom();
            }

        });
        downThread.start();

        // UP-Thread
        Thread uThread = new Thread(() ->
        {
            while (true)
            {
                boundedCounter.up();
                sleepRandom();
            }
        });
        uThread.start();
    }

}
