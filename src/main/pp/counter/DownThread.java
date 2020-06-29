package pp.counter;

public class DownThread extends Thread
{
    private int n;

    private BoundedCounter boundedCounter;

    public DownThread(BoundedCounter boundedCounter, int n)
    {
        this.boundedCounter = boundedCounter;
        this.n = n;
    }

    @Override
    public void run()
    {
        int k = 0;
        while (k < n)
        {
            this.boundedCounter.down();
            k++;
        }
    }
}
