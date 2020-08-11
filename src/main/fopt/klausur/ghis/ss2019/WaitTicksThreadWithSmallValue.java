package fopt.klausur.ghis.ss2019;

public class WaitTicksThreadWithSmallValue extends Thread
{
    private LogicalTime logicalTime;

    public WaitTicksThreadWithSmallValue(String name, LogicalTime logicalTime)
    {
        this.setName(name);
        this.logicalTime = logicalTime;
        this.start();
    }

    @Override
    public void run()
    {
        // Siehe Aufgabe Paramter n = 30;
        this.logicalTime.waitTicks(30);
    }

}
