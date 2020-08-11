package fopt.klausur.ghis.ss2019;

public class LogicalTime
{
    public synchronized void tick()
    {
        this.notifyAll();
    }

    public synchronized void waitTicks(int waitingTicks)
    {
        int ticks = waitingTicks;
        while (ticks > 0)
        {
            try
            {
                System.out.println(ticks + " -> waitTicks() " + Thread.currentThread().getName());
                this.wait();
                ticks--;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
