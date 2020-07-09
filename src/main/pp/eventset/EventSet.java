package pp.eventset;

public class EventSet
{
    private boolean[] feld;

    public EventSet(int feldLength)
    {
        if (feldLength < 0)
        {
            throw new IllegalArgumentException("Feld length mus be > 0");
        }
        this.feld = new boolean[feldLength];
    }

    public synchronized void set(int position, boolean feldValue)
    {
        if (position < 0 || position >= this.feld.length)
        {
            throw new IllegalArgumentException("Position must be in feld range [0," + this.feld.length + "]");
        }

        this.feld[position] = feldValue;
        System.out.println("Feldelement is set  at: " + position + "--> " + feldValue);
        this.notifyAll();

    }

    public synchronized void waitAND()
    {
        while (!this.checkIfAllTrue())
        {
            try
            {
                this.wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        // 1. Warum nicht Notify?
        //
        this.notifyAll();

    }

    public synchronized void waitOR()
    {
        while (!this.checkIfAtLeastOneTrue())
        {
            try
            {
                this.wait();
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        this.notifyAll();
    }

    private boolean checkIfAtLeastOneTrue()
    {
        for (int i = 0; i < feld.length; i++)
        {
            if (feld[i])
            {
                return true;
            }

        }
        return false;

    }

    private boolean checkIfAllTrue()
    {
        for (int i = 0; i < feld.length; i++)
        {
            if (!feld[i])
            {
                return false;
            }
        }
        return true;
    }

}
