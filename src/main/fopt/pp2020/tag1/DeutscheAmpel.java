package fopt.pp2020.tag1;

public class DeutscheAmpel implements Ampel
{

    // Gruen oder Rot
    private String ampel;

    // Repraesentiert die Anzahl der wartenden Auto an der Ampel
    private int numberOfWaitingCars;

    private int nextWaitingNumber;

    private int nextRollingNumber;

    public DeutscheAmpel()
    {
        this.ampel = Ampel.Gruen;
        this.numberOfWaitingCars = 0;
        this.nextWaitingNumber = 0;
        this.nextRollingNumber = 0;
    }

    // sync weil Aenderung des Zustands durch unterchiedliche Threads
    @Override
    public synchronized void schalteRot()
    {
        this.ampel = Ampel.Rot;

    }

    // sync--> Weil Aenderung des Zustand durch unterchiedliche Threads
    @Override
    public synchronized void schalteGruen()
    {
        this.ampel = Ampel.Gruen;
        // Denn mehrere Threads koennen While-Wait-Schleife/ verlassen
        this.notifyAll();

    }

    @Override
    public synchronized void passieren()
    {
        int myNumber = this.nextWaitingNumber;

        // Bereitstellung der naechste Wartenummer
        this.nextWaitingNumber++;
        this.numberOfWaitingCars++;
        // Frage: Wann soll ein Auto warten?
        // 1. wenn Ampel ist rot oder
        // 2. Wartenummer und Anfahrende Nummer sind nicht identisch
        while (this.ampel.equals(Ampel.Rot) || myNumber != this.nextRollingNumber)
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + " DEUTSCH- WAITING Nr . " + myNumber);
                this.wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " DEUTSCH- ROOLING Nr . " + myNumber);

        this.numberOfWaitingCars--;
        this.nextRollingNumber++;

        // Benachrichtigen andere Autos
        this.notifyAll();

    }

    // sync weil? -- schreibende
    @Override
    public synchronized int wartendeFahrzeuge()
    {
        return this.numberOfWaitingCars;
    }

}
