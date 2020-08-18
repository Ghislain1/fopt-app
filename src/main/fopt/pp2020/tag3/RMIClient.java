package fopt.pp2020.tag3;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient
{

    public static void main(String[] args)
    {
        String url = "rmi://localhost/demo";
        try
        {
            Data data = new Data();
            IDemo demo = (IDemo) Naming.lookup(url);
            System.out.println("CLIENT > " + data.getValue());
            demo.increment(data);
            System.out.println("CLIENT > " + data.getValue());
        }
        catch (MalformedURLException | RemoteException | NotBoundException e)
        {
            e.printStackTrace();
        }

    }

}
