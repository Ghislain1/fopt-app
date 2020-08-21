package fopt.klausur.ghis.ss2019;

import java.util.LinkedList;

public class LogicalTime
{
    private int overallTicks;

    private LinkedList<Thread> runningThreadList;

    public LogicalTime()
    {

        this.overallTicks = 0;
        this.runningThreadList = new LinkedList<Thread>();
    }

    public synchronized void tick()
    {
        this.overallTicks++;
        this.notifyAll();
        System.out.println(this.overallTicks);

    }

    public synchronized boolean hasThreadInWaiting()
    {
        return !this.runningThreadList.isEmpty();
    }

    public synchronized void waitTicks(int waitingTicks)
    {
        // Append to list
        this.runningThreadList.add(Thread.currentThread());
        int ticks = this.overallTicks + waitingTicks;

        while (ticks - this.overallTicks > 0)
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + " *** WAITING  ====>  " + waitingTicks);
                this.wait();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        this.runningThreadList.remove(Thread.currentThread());
        System.out.println(Thread.currentThread().getName() + " ****   PASSING   *** ");

    }

}
