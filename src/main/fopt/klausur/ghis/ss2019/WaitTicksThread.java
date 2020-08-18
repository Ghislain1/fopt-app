package fopt.klausur.ghis.ss2019;

public class WaitTicksThread extends Thread
{
    private LogicalTime2 logicalTime;

    public WaitTicksThread(String name, LogicalTime2 logicalTime)
    {
        this.setName(name);
        this.logicalTime = logicalTime;
        this.start();
    }

    @Override
    public void run()
    {

        // Siehe Aufgabe Paramter n = 50;
        this.logicalTime.waitTicks(50);

    }
}
