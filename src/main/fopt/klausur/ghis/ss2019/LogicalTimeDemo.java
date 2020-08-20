package fopt.klausur.ghis.ss2019;

public class LogicalTimeDemo
{

    public static void main(String[] args) throws InterruptedException
    {
        // gemeinsam genutzter Objekt anlegen
        LogicalTime logicalTime = new LogicalTime();

        // For waitTicks() Methods
        WaitTicksThread t2 = new WaitTicksThread("WaitTicksThread", logicalTime);
        WaitTicksThreadWithSmallValue t1 = new WaitTicksThreadWithSmallValue("WaitTicksThreadWithSmallValue", logicalTime);

        // Ziel Thread t1 oder t1 soll wieder aufgewacht werden nach Paramter n,
        // NICHT jedes Mal.

        Thread.sleep(10000);

        // for tick()-Methode
        TickThread tickThread = new TickThread("tickThread", logicalTime);
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
