package fopt.lehrmaterial.auf93;

import java.util.concurrent.Semaphore;

public class Displaying
{
    // Lesen Sie noch Abschnitt 3.2.2
    // Semaphore für gegenseitiger Ausschluss --NEIN
    public static void main(String[] args)
    {

        // Warum Semaphore mit Init wert 0?
        Semaphore[] semaphoreArray = new Semaphore[]
        { new Semaphore(1), new Semaphore(0) };
        new Displayer(semaphoreArray);
        new DisplayerOther(semaphoreArray);

    }

}
