package fopt.klausur.ghis.ss2019;

public class WaitTicksThread extends Thread
{
    private LogicalTime logicalTime;

    public WaitTicksThread(String name, LogicalTime logicalTime)
    {
        this.setName(name);
        this.logicalTime = logicalTime;
        this.start();
    }

    @Override
    public void run()
    {

        this.logicalTime.waitTicks(10);

    }
}
