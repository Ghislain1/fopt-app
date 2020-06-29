package pp.counter;

public class BoundedCounter
{
    private int counter;

    private int max, min;

    public BoundedCounter(int min, int max)
    {
        if (min >= max)
        {
            throw new IllegalArgumentException("min must < than max");
        }
        this.counter = min;
        this.min = min;
        this.max = max;

    }

    public synchronized void up()
    {
        try
        {
            while (counter >= this.max)
            {
                this.wait();
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        this.counter++;
        this.notifyAll();
    }

    public synchronized void down()
    {
        try
        {
            while (this.counter <= this.min)
            {
                this.wait();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        this.counter--;
        this.notifyAll();
    }

    public synchronized int get()
    {
        return this.counter;
    }
}
