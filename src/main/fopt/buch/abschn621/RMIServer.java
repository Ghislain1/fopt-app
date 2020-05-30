package fopt.buch.abschn621;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

// Hier wird die Server ausprogrammiert.
// Erzeugen ein CounterImpl Objekt
// Registrieren das Objekt bei der Auskunft?
// 1. Wer ist die Auskunft bei RMI?
// 2. Wo soll man das Kommando rmiregistry durchführen? 
public class RMIServer
{

    public static void main(String[] args)
    {
        try
        {
            CounterImpl counter = new CounterImpl();

            // Anmeldung des Objektes
            Naming.rebind("CounterName", counter);

        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }

    }

}
// 1. Betriebsystem?