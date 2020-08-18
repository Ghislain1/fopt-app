package fopt.buch.abschn621;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

//Hier wird client  ausprogrammiert, ein Beispiel fuer die Aufrufen der Methoden reset() un increment()
//1. Wie lautet der Syntax der Paramteruebergabe bei Lookup() Methode aus Naming Klasse?
public class RMIClient
{

    public static void main(String[] args)
    {
        // rmi://<Rechnername>/<Objektname>
        String rechnername = "localhost";
        String objektname = "CounterName";
        String url = "rmi://" + rechnername + "/" + objektname;

        try
        {
            Counter counter = (Counter) Naming.lookup(url);
            counter.reset();
            for (int i = 0; i < 10; i++)
            {
                counter.increment();
            }
        }
        catch (MalformedURLException e)
        {

            e.printStackTrace();
        }
        catch (RemoteException e1)
        {

            e1.printStackTrace();
        }
        catch (NotBoundException e2)
        {

            e2.printStackTrace();
        }

    }

}
// 1. rmi://<Rechnername>/<Objektname>