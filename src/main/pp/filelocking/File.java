package pp.filelocking;

import java.util.ArrayList;

public class File
{
    private int length;

    private boolean found;

    private ArrayList<Integer> sperreIntervall;

    public File(int length)
    {
        if (length < 0)
        {
            throw new IllegalArgumentException("length must be positiv");
        }
        this.length = length;
        this.sperreIntervall = new ArrayList<>();
    }

    private boolean checkStatus(int begin, int end)
    {
        boolean result = false;
        int size = this.sperreIntervall.size();
        for (int k = 0; k < size; k += 2)
        {
            // System.out.println(" [" + this.sperreIntervall.get(k) + "," +
            // this.sperreIntervall.get(k + 1) + "] ");
            if (this.sperreIntervall.get(k) == begin && this.sperreIntervall.get(k + 1) == end)
            {
                result = true;
                // break;
            }

        }
        return result;
    }

    public synchronized void lock(int begin, int end)
    {
        if (begin < 0 || end > length)
        {
            throw new IllegalArgumentException("Wrong intervall");
        }
        this.found = this.checkStatus(begin, end);
        while (!this.found)
        {
            try
            {
                this.sperreIntervall.add(begin);
                this.sperreIntervall.add(end);
                System.out.println("   " + this.sperreIntervall.size());
                this.wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public synchronized void unlock(int begin, int end)
    {
        if (begin < 0 || end > length)
        {
            throw new IllegalArgumentException("Wrong intervall");
        }

        this.found = this.checkStatus(begin, end);
        if (!this.found)
        {
            return;
        }
        this.notifyAll();
    }
}
