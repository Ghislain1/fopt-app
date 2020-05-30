package fopt.lehrmaterial.auf93;

import java.util.concurrent.Semaphore;

public class Displaying
{
    // Lesen Sie noch Abschnitt 3.1.3
    // Semaphore für gegenseitiger Ausschluss --NEIN
    public static void main(String[] args)
    {

        // Warum Semaphore mit Init wert 0?
        Semaphore semaphoreEine = new Semaphore(1);
        Semaphore semaphoreAndere = new Semaphore(0);
        new Displayer(semaphoreEine, semaphoreAndere);
        new DisplayerOther(semaphoreEine, semaphoreAndere);

    }

}
