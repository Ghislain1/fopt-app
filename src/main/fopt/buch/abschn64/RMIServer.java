package fopt.buch.abschn64;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class RMIServer
{

    public static void main(String[] args)
    {

        // Registry
        try
        {
            // RemoteOject
            Append append = new AppendImpl();
            Naming.rebind("Append", append);
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
