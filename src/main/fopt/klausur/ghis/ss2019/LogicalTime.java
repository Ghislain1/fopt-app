package fopt.klausur.ghis.ss2019;

import java.util.Random;

public class LogicalTime
{

    private int nextWaitingNumber;

    private boolean canSetTicks;

    private int nextEnteringNumber;

    private int ticks;

    public LogicalTime()
    {
        this.nextWaitingNumber = 0;
        this.nextEnteringNumber = 0;
    }

    public synchronized void tick()
    {
        System.out.println(Thread.currentThread().getName() + ": " + ticks);

        if (this.ticks == 0)
        {
            // this.notify();
            this.canSetTicks = true;
            this.notifyAll();

        }
        else
        {
            this.ticks--;
        }

    }

    public synchronized void waitTicks(int waitingTicks)
    {
        int myNumber = this.nextWaitingNumber++;
        int newWaitingTicks = waitingTicks;

        while (newWaitingTicks > 0)
        {
            try
            {
                // System.out.println(Thread.currentThread().getName() + "ist
                // this.ticks = waitingTicks;
                this.wait();
                newWaitingTicks--;
                System.out.println("-------------------> " + Thread.currentThread().getName() + " ist geweckt!");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        this.canSetTicks = true;
        // this.notifyAll();

    }

    private void sleepRandom()
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
