package fopt.pp2020.tag3;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class RMIServer
{

    public static void main(String[] args)
    {

        try
        {
            Naming.rebind("demo", new Demo());
        }
        catch (RemoteException | MalformedURLException e)
        {

            e.printStackTrace();
        }
    }

}
