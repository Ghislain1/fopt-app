package fopt.pp2020.tag1;

public class AmpelDemo
{

    public static void main(String[] args)
    {
        int maxNumberOfCars = 10;
        // Gemeinsam genutzter Objekt
        Ampel[] ampelFeld = new Ampel[]
        { new DeutscheAmpel(), new ItalienischeAmpel() };

        new Steuerung(ampelFeld);

        for (int i = 0; i < maxNumberOfCars; i++)
        {
            new Auto(ampelFeld);
        }

    }

}
