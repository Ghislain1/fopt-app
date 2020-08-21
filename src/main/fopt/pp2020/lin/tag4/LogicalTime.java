package fopt.pp2020.lin.tag4;

public class LogicalTime {

    private int overallTicks = 0;

    public synchronized void tick()
    {
        overallTicks++;
        System.out.println(Thread.currentThread().getName() + "-->" + overallTicks);
        notifyAll();
    }

    public synchronized void waitTicks(int waitingTicks)
    {
        int startTicks = overallTicks;

        int differ = overallTicks - startTicks;

        while(overallTicks - startTicks < waitingTicks)
        {
            try
            {
                wait();
                System.out.println(Thread.currentThread().getName() + "-->" + differ);
                System.out.println("startTicks" + "-->" + startTicks);
                System.out.println("overallTicks" + "-->" + overallTicks);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "++++++" + differ);
    }
}
