package fopt.buch.abschn64;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AppendImpl extends UnicastRemoteObject implements Append
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected AppendImpl() throws RemoteException
    {
        super();
    }

    // TODO@GHZE: 1. Warum sollen wir diese synchronized kenntzeichnen?
    @Override
    public synchronized void tryToAppend(List listObject) throws RemoteException
    {
        // Store it somewhere
        listObject.print();
    }
}

// 1. Damit sind wir vorbeireiten, dass mehrere Client Thread-Safe ansprechen
// koennen.
