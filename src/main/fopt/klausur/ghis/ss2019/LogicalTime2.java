package fopt.klausur.ghis.ss2019;

import java.util.LinkedList;

public class LogicalTime2
{
    private int ticks;

    // To Store all thread for ticks
    private LinkedList<Thread> threadLinkedList;

    public LogicalTime2()
    {
        this.threadLinkedList = new LinkedList<>();
        this.ticks = 0; // NOT Zero , because the first enter thread should wait
    }

    public synchronized void tick()
    {
        this.ticks--;
        this.notifyAll();
    }

    public synchronized void waitTicks(int waitingTicks)
    {
        // Einfuegen in der Wartenschlange
        this.threadLinkedList.add(Thread.currentThread());

        // Wenn das erste Element in der Warteschlange nicht das Aktual ist dann
        // warten oder ticks noch nicht null erreicht hat --> Dann warten
        while (this.ticks == 0 || this.threadLinkedList.get(0) != Thread.currentThread())
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + " *** WAITING  ***  ");
                this.wait();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        // Raus von der Warteschlage
        this.threadLinkedList.remove(Thread.currentThread());

        // The Ticks bereitstellen
        this.ticks = waitingTicks;

        //
        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + " ****   PASSING   *** ");

    }

}
