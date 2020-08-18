package fopt.pp2020.tag3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IDemo extends Remote
{
    public void increment(Data data) throws RemoteException;
}
