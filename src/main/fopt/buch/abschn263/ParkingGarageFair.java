package fopt.buch.abschn263;

public class ParkingGarageFair
{
    // Repraesentiert die Anzahl der freien Plaetze in Parkhaus
    private int places;

    // Repraesentiert eine Wartenummer
    private int nextWaitingNumber;

    // Repraesentiert die Number eines anfahrenden Autos
    private int nextEnteringNumber;

    /**
     * Initialize die anzahl der maximale Plaetze in Parkhaus
     * 
     */
    public ParkingGarageFair(int places)
    {
        if (places <= 0)
        {
            throw new IllegalArgumentException("Anzahl der Plaetze sind nicht richtig!");
        }
        this.places = places;

    }

    /**
     * Was soll passiert wenn ein Auto ins Parkhaus anfahren moechte? -
     * 
     * - Seine Nummer anzeigen ...
     * 
     * - Das System ehroeht die wartenummer ---
     * 
     * - Das System prueft ob das Auto uerberhaupt anfahren darf.
     **/
    public synchronized void enter()
    {
        int myNummer = this.nextWaitingNumber;

        // Bereitstellung der naechsten Wartenummer
        this.nextWaitingNumber++;

        // Frage: Wann darf ein Auto NICHT anfahren?
        // Plaetze und Wartenummer
        while (places == 0 || this.nextEnteringNumber != myNummer)
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + "******************  WAIT Nr. " + myNummer);
                this.wait();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        // Freie Plaetze redukzieren
        this.places--;

        // Bereistellung des naechsten anfahrenden Autos
        this.nextEnteringNumber++;

        // Benachrichtigen andere Autos
        this.notifyAll();

    }

    public synchronized void leave()
    {
        // Was soll passieren, wenn ein Auto das Parking verlaesst?

        // Freie Plaetze minnt zu
        this.places++;

        // Benachrichtigen andere Autos -- Hey es gibt einen neuen freien Platze
        this.notifyAll();

    }

}
