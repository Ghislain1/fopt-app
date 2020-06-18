package pp.eventset;

public class EventSetThread extends Thread
{
    private EventSet eventSet;

    public EventSetThread(EventSet eventSet)
    {
        if (eventSet == null)
        {
            throw new IllegalArgumentException("eventSet must be not null");
        }
        this.eventSet = eventSet;
        this.start();
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(1000 * 5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        this.setAtLeastOneTrue();
    }

    private void setAtLeastOneTrue()
    {
        this.eventSet.set(0, false);
        for (int i = 1; i < 5; i++)
        {
            this.eventSet.set(i, true);

        }

    }

    private void setAllTrue()
    {
        for (int i = 0; i < 5; i++)
        {
            this.eventSet.set(i, true);

        }

    }
}
