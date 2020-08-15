package fopt.buch.abschn263;

public class ParkingGarageFairDemo
{

    public static void main(String[] args)
    {
        // gemeinsamer genutzter Objekt
        ParkingGarageFair parkingGarageFair = new ParkingGarageFair(7);

        for (int k = 1; k <= 10; k++)
        {
            new Auto(parkingGarageFair, "Auto Nr" + k);
        }
    }

}
