package fopt.klausur.ghis.ss2019;

public class WaitTicksThreadWithSmallValue extends Thread
{
    private LogicalTime2 logicalTime;

    public WaitTicksThreadWithSmallValue(String name, LogicalTime2 logicalTime)
    {
        this.setName(name);
        this.logicalTime = logicalTime;
        this.start();
    }

    @Override
    public void run()
    {
        // Siehe Aufgabe Paramter n = 5;
        this.logicalTime.waitTicks(7);
    }

}
