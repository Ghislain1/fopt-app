package fopt.lehrmaterial.auf93;

import java.util.concurrent.Semaphore;

public class DisplayerOther extends Thread
{

    Semaphore[] semaphoreArray;

    public DisplayerOther(Semaphore[] semaphoreArray)
    {
        super();

        this.semaphoreArray = semaphoreArray;
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
                this.semaphoreArray[1].acquire();

                this.say();

                sleep((int) (Math.random() * 10000)); // Nur zum Verlangsamen

                // a1--> a0
                this.semaphoreArray[0].release();

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

}
