package fopt.lehrmaterial.auf93;

import java.util.concurrent.Semaphore;

public class Displayer extends Thread
{
    Semaphore[] semaphoreArray;

    public Displayer(Semaphore[] semaphoreArray)
    {
        super();

        this.semaphoreArray = semaphoreArray;
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
                this.semaphoreArray[0].acquire();
                this.say();

                sleep((int) (Math.random() * 1000)); // Nur zu verlangsamen der
                                                     // Aufgabe

                this.semaphoreArray[1].release();

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

}
