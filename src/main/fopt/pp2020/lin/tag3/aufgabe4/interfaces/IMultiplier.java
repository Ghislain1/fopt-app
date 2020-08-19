package fopt.pp2020.lin.tag3.aufgabe4.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMultiplier extends Remote
{
    public int multiply(int a, int b) throws RemoteException;
}
