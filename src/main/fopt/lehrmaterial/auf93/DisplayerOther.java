package fopt.lehrmaterial.auf93;

import java.util.concurrent.Semaphore;

public class DisplayerOther extends Thread
{
    private Semaphore semaphoreEine;

    private Semaphore semaphoreAndere;

    public DisplayerOther(Semaphore semaphoreEine, Semaphore semaphoreAndere)
    {
        super();
        if (semaphoreAndere == null || semaphoreAndere == null)
        {
            throw new NullPointerException("Semaphore could NOT be Null!!");
        }
        this.semaphoreEine = semaphoreEine;
        this.semaphoreAndere = semaphoreAndere;

        // Thread Erwecken!!
        this.start();
    }

    private void say()
    {
        System.out.println("Ich bin der andere");
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                // a0---> a1
                this.semaphoreAndere.acquire();

                this.say();

                sleep((int) (Math.random() * 10000)); // Nur zum Verlangsamen

                // a1--> a0
                // Siehe Abschnitt 3.1.3 zu beschreiben this Action!!
                this.semaphoreEine.release();

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

}
