package fopt.buch.abschn64;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient
{

    public static void main(String[] args)
    {
        try
        {
            // TODO@GhZe- 1. Wie lautet die Url als Parameter der
            // Lookup()-Method
            // von Naming
            String url = "rmi://localhost/Append";
            Append append = (Append) Naming.lookup(url);

            // Object to send to server
            List listObject = new List();
            for (int i = 0; i < 12; i++)
            {
                listObject.append(i);
            }

            append.tryToAppend(listObject);
        }
        catch (MalformedURLException e1)
        {

            e1.printStackTrace();
        }
        catch (RemoteException e2)
        {

            e2.printStackTrace();
        }
        catch (NotBoundException e3)
        {

            e3.printStackTrace();
        }
    }
}

// 1. rmi://<ServerName>/RemoteObjectName
