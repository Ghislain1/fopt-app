package fopt.video.rmi.sleep;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class SleepServer
{
    public static void main(String[] args)
    {
        try
        {
            // Auskunft einbinden.
            // TODO@hZe Standardmaessig laueft auf Port 1099 bei RMI
            Naming.rebind("Sleep", new SleepImpl());
        }
        catch (RemoteException | MalformedURLException e)
        {
            System.out.println(e);
            e.printStackTrace();
        }

    }

}
