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
        int leng = this.zahlenschloss.anzahlRädchen();

        while (!interrupted())
        {

            for (int radnummer = 0; radnummer < leng; radnummer++)
            {

                System.out.print(" " + this.zahlenschloss.lesen(radnummer));
            }
            System.out.println();
        }

    }
}
