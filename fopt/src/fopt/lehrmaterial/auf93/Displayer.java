package fopt.lehrmaterial.auf93;

import java.util.concurrent.Semaphore;

public class Displayer extends Thread
{
    private String message;

    Semaphore semaphore;

    public Displayer(String message, Semaphore semaphore)
    {
        super();
        this.message = message;
        this.semaphore = semaphore;
        this.start();

    }

    @Override
    public void run()
    {
        // Warte Bediengung soll Programmiert werden!!
        while (true)
        {

            try
            {
                this.semaphore.acquire();

                System.out.println(message);

                sleep((int) (Math.random() * 1000)); // Nur zu verlangsamen der
                                                     // Aufgabe
                this.semaphore.release();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

}
