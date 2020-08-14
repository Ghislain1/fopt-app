package fopt.pp2020.tag1;

public class DeutscheAmpel implements Ampel
{

    // Gruen oder Rot
    private String ampel;

    private int numberofWaitingCar;

    private int nextWaitingCar;

    private int nextRollingCar;

    public DeutscheAmpel()
    {
        this.ampel = Ampel.Rot;
        this.numberofWaitingCar = 0;
    }

    // sync weil Aenderung des Zustand durch unterchiedliche Threads
    @Override
    public synchronized void schalteRot()
    {
        this.ampel = Ampel.Rot;

    }

    // sync weil Aenderung des Zustand durch unterchiedliche Threads
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
        int numberCar = nextWaitingCar++;
        while (this.ampel.equals(Ampel.Rot) && numberCar != this.nextRollingCar)
        {
            try
            {

                this.numberofWaitingCar++;
                this.wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        this.nextRollingCar++;
        this.numberofWaitingCar--;

        this.notifyAll();

    }

    // sync weil? -- schreibende
    @Override
    public synchronized int wartendeFahrzeuge()
    {
        return this.numberofWaitingCar;
    }

}
