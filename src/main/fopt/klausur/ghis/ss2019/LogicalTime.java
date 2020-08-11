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

                this.wait();
                ticks--;
                System.out.println(Thread.currentThread().getName() + ": " + ticks);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
