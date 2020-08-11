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
        WaitTicksThreadWithSmallValue t1 = new WaitTicksThreadWithSmallValue("t Nr.1", logicalTime);
        WaitTicksThread t2 = new WaitTicksThread("t Nr.2", logicalTime);

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
