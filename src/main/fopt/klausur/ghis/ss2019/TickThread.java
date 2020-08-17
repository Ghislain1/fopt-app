package fopt.klausur.ghis.ss2019;

public class TickThread extends Thread
{
    private LogicalTime2 logicalTime;

    public TickThread(String name, LogicalTime2 logicalTime)
    {
        this.setName(name);
        this.logicalTime = logicalTime;
        this.start();
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                // Sekundentakt!!
                Thread.sleep(1000);
            }
            catch (Exception e)
            {

            }

            // Call tick Methods
            this.logicalTime.tick();
        }
    }
}
