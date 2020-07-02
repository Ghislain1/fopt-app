package fopt.klausur.ws2013;

public class ZahlenschlossLeserThread extends Thread
{
    private Zahlenschloss zahlenschloss;

    public ZahlenschlossLeserThread(Zahlenschloss zahlenschloss)
    {
        this.zahlenschloss = zahlenschloss;
        this.start();
        System.out.println("Leser is starting!!");
    }

    @Override
    public void run()
    {

        while (!interrupted())
        {

            for (int i = 0; i < this.zahlenschloss.anzahlRaedchen(); i++)
            {

                System.out.print(" " + this.zahlenschloss.lesen(i));
            }
            System.out.println();
        }

    }
}
