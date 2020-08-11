package fopt.klausur.ghis.ss2019;

public class LogicalTimeDemo
{

    public static void main(String[] args)
    {
        // gemeinsam genutzter Objekt anlegen
        LogicalTime logicalTime = new LogicalTime();

        // for tick()-Methode
        TickThread tickThread = new TickThread("tickThread", logicalTime);

        // For waitTicks() Methods
        WaitTicksThread t2 = new WaitTicksThread("WaitTicksThread", logicalTime);
        WaitTicksThreadWithSmallValue t1 = new WaitTicksThreadWithSmallValue("WaitTicksThreadWithSmallValue", logicalTime);

        // Ziel Thread t1 oder t1 soll wieder aufgewacht werden nach Paramter n,
        // NICHT jedes Mal.
        try
        {
            t1.join();
            t2.join();
            tickThread.join();
            System.out.println("All Threads terminated successfully!!! ######################");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

}
