package fopt.klausur.ghis.ss2019;

public class LogicalTime
{
    public static int MAX_NUMBER_OF_TICKS_LONG = 10;

    public static int MAX_NUMBER_OF_TICKS_SMALL = 5;

    private int nextWaitingNumber;

    private int nextPassingNumber;

    private int ticks;

    public LogicalTime()
    {
        this.nextWaitingNumber = 0;
        this.nextPassingNumber = 0;
        this.ticks = 0; // NOT Zero , because the first enter thread should wait
    }

    public synchronized void tick()
    {

        if (this.ticks == 0)
        {

            this.notifyAll();

        }
        else
        {
            this.ticks--;
        }

    }

    public synchronized void waitTicks(int waitingTicks)
    {
        // Nummber ziehen
        int myNumber = this.nextWaitingNumber;

        // Wartenummer bereitstellen
        this.nextWaitingNumber++;

        while (this.ticks > 0 || myNumber != this.nextPassingNumber)
        {
            try
            {
                // TODO@GhZe nochmal vor klausur
                System.out.println(Thread.currentThread().getName() + " *** WAITING  *** : ");
                this.wait();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        this.ticks = waitingTicks;
        this.nextPassingNumber++;
        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + " ****   PASSING   *** ");

    }

}