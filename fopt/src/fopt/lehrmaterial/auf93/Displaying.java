package fopt.lehrmaterial.auf93;

import java.util.concurrent.Semaphore;

public class Displaying
{

    public static void main(String[] args)
    {
        // Lesen Sie noch Abschnitt 3.2.2
        // Semaphore für gegenseitiger Ausschluss --NEIN
        Semaphore[] semaphoreArray = new Semaphore[]
        { new Semaphore(1), new Semaphore(1) };
        new Displayer(semaphoreArray);
        new DisplayerOther(semaphoreArray);

    }

}
