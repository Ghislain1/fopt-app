package fopt.pp2020.tag1;

public class BoundedCounter
{
    private int maximumWert;

    private int minimumWert;

    private int counter;

    public BoundedCounter(int minimumWert, int maximumWert)
    {
        if (maximumWert <= minimumWert)
        {
            throw new IllegalArgumentException("Wrong paramters Angaben");
        }
        this.minimumWert = minimumWert;
        this.maximumWert = maximumWert;
        this.counter = minimumWert;

    }

    // Attributwert um eins erhoehen
    public synchronized void up()
    {
        // Kritisch Bereich
        while (this.counter >= this.maximumWert)
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + " WAITING...");
                this.wait();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        this.counter++;
        // Denn mehrere Thread koennen Ihre While-Wait-Schleife verlasen
        this.notifyAll();
    }

    public synchronized void down()
    {
        // Kritischer Bereich
        while (this.counter <= this.minimumWert)
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + " WAITING...");
                this.wait();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        this.counter--;
        this.notifyAll();
    }

    // Aktueller Wert zuruekliefern
    public synchronized int get()
    {
        return this.counter;
    }
}
