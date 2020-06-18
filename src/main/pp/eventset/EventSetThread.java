package pp.eventset;

public class EventSetThread extends Thread
{
    public EventSet eventSet;

    public EventSetThread(EventSet eventSet)
    {
        this.eventSet = eventSet;
        this.start();
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 100; i++)
        {

            this.eventSet.set(true);

            try
            {
                Thread.sleep(1000 * 5);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
