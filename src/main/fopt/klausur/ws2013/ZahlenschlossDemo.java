package fopt.klausur.ws2013;

import java.util.Scanner;

public class ZahlenschlossDemo
{

    public static void main(String[] args)
    {
        System.out.print("Gib  'stop' ein, um der Prozess zu stoppen : ");
        Zahlenschloss zahlenschloss = new Zahlenschloss(new int[5]);

        for (int i = 1; i <= 5; i++)
        {
            new ZahlenschlossThread(zahlenschloss, "Thread Nr. " + i);
        }

        Thread leserThread = new ZahlenschlossLeserThread(zahlenschloss);

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.equals("stop"))
        {
            leserThread.interrupt();
        }
        scanner.close();

    }

}
