package fopt.lehrmaterial.auf93;

import java.util.concurrent.Semaphore;

public class Displaying
{

    public static void main(String[] args)
    {
        // Lesen Sie noch Abschnitt 3.2.1
        // Semaphore für gegenseitiger Ausschluss
        Semaphore semaphore = new Semaphore(1);
        new Displayer("Ich bin eine", semaphore);
        new Displayer("Ich bin der andere", semaphore);

    }

}
