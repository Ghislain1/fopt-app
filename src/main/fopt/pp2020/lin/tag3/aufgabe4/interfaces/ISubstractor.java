package fopt.pp2020.lin.tag3.aufgabe4.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISubstractor extends Remote
{
    public int substract(int a, int b) throws RemoteException;
}
