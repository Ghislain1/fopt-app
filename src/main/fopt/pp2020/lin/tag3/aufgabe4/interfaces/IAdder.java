package fopt.pp2020.lin.tag3.aufgabe4.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAdder extends Remote
{
    public int add(int a, int b) throws RemoteException;
}
