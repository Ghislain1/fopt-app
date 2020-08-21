package fopt.video.rmi.sleep;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SleepImpl extends UnicastRemoteObject implements Sleep
{

    protected SleepImpl() throws RemoteException
    {

    }

    // Synchronized ist nicht relevant hier da keine gemeinensam daten
    // Variant 1: MIT synchronized
    // Variant 2 : OHNE synchronized
    @Override
    public synchronized void sleep(int secs) throws RemoteException
    {
        try
        {
            System.out.println(" schlaf! =============> " + secs);
            // 5 Sekunden-Schlaf
            Thread.sleep(1000 * secs);
            System.out.println(" wach! ==================> " + secs);
        }
        catch (InterruptedException e)
        {
            System.out.println(e);
            e.printStackTrace();
        }

    }

}
