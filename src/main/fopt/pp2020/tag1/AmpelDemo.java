package fopt.pp2020.tag1;

public class AmpelDemo
{

    public static void main(String[] args)
    {
        // int maxNumberOfCars = 10;
        // Gemeinsam genutzter Objekt
        // { new DeutscheAmpel(), new ItalienischeAmpel() };
        Ampel[] ampelFeld = new Ampel[2];
        ampelFeld[0] = new ItalienischeAmpel();
        ampelFeld[1] = new DeutscheAmpel();

        // Steuerung laufen lassen
        new Steuerung(ampelFeld);

        for (int i = 1; i <= 5; i++)
        {
            Auto sd = new Auto(ampelFeld);
            sd.setName("AUTO Nr " + i);
            try
            {
                // 5 Sekundentakt kommt ein auto an
                Thread.sleep(5000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }

}
