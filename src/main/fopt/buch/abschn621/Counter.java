package fopt.buch.abschn621;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Counter extends Remote
{
    public int reset() throws RemoteException;

    public int increment() throws RemoteException;
}
