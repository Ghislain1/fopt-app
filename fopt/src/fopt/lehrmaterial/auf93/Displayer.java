package fopt.lehrmaterial.auf93;

import java.util.concurrent.Semaphore;

public class Displayer extends Thread
{
    private Semaphore semaphoreEine;

    private Semaphore semaphoreAndere;

    public Displayer(Semaphore semaphoreEine, Semaphore semaphoreAndere)
    {
        super();
        if (semaphoreAndere == null || semaphoreAndere == null)
        {
            throw new NullPointerException("Semaphore could NOT be Null!!");
        }
        this.semaphoreEine = semaphoreEine;
        this.semaphoreAndere = semaphoreAndere;
        this.start();

    }

    private void say()
    {
        System.out.println("Ich bin der eine");
    }

    @Override
    public void run()
    {
        while (true)
        {

            try
            {
                // 1. Der Initialwert wird auf 0 gesetzt bzw.
                // aufrufendende Thread warten
                this.semaphoreEine.acquire();

                // Meldung auf die Console schreiben
                this.say();

                sleep((int) (Math.random() * 1000)); // Nur zu verlangsamen der
                                                     // Aufgabe
                // einer der DisplayOther freigeben
                // Alternierende zu simulieren
                this.semaphoreAndere.release();

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

}
