package pp.eventset;

import java.util.Random;

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

    public void set(boolean feldValue)
    {
        Random random = new Random();
        int max = this.feld.length - 1;
        int min = 0;
        int randomNumber = random.nextInt(max + 1 - min) + min;
        this.feld[randomNumber] = feldValue;
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
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
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
            if (feld[i])
            {
                return false;
            }
        }
        return true;
    }

}
