package fopt.pp2020.tag1;

public interface Ampel
{
    public static String Gruen = "Gruen";

    public static String Rot = "Rot";

    public void schalteRot();

    public void schalteGruen();

    /**
     * Vorbeifahren nachbilden
     */
    public void passieren();

    /**
     * Liefert wieviel Autos momentan am Ampel stehen.
     */
    public int wartendeFahrzeuge();
}
