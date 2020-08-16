package fopt.klausur.ghis.ss2019;

public class TickThread extends Thread
{
    private LogicalTime logicalTime;

    public TickThread(String name, LogicalTime logicalTime)
    {
        this.setName(name);
        this.logicalTime = logicalTime;
        this.start();
    }

    @Override
    public void run()
    {
        for (int i = 0; i < LogicalTime.MAX_NUMBER_OF_TICKS_SMALL + LogicalTime.MAX_NUMBER_OF_TICKS_LONG; i++)
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
