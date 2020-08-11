package fopt.klausur.ghis.ss2019;

public class LogicalTimeDemo
{

    public static void main(String[] args)
    {
        // gemeinsam genutzter Objekt anlegen
        LogicalTime logicalTime = new LogicalTime();

        WaitTicksThreadWithSmallValue WaitTicksThreadWithSmallValue = new WaitTicksThreadWithSmallValue("WaitTicksThreadWithSmallValue", logicalTime);

        TickThread tickThread = new TickThread("tickThread", logicalTime);
        WaitTicksThread waitTicksThread1 = new WaitTicksThread("waitTicksThread Nr.1", logicalTime);
        try
        {
            waitTicksThread1.join();
            WaitTicksThreadWithSmallValue.join();
            tickThread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

}
