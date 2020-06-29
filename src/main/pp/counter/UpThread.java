package pp.counter;

public class UpThread extends Thread
{
    private BoundedCounter boundedCounter;

    private int n;

    public UpThread(BoundedCounter boundedCounter, int limit)
    {
        this.boundedCounter = boundedCounter;
        this.n = limit;
    }

    @Override
    public void run()
    {
        int k = 0;
        while (k < n)
        {
            this.boundedCounter.up();
            k++;
        }
    }
}
