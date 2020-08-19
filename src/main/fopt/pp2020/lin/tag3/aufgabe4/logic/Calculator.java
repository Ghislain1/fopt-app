package fopt.pp2020.lin.tag3.aufgabe4.logic;



import fopt.pp2020.lin.tag3.aufgabe4.interfaces.IAdder;
import fopt.pp2020.lin.tag3.aufgabe4.interfaces.IDivider;
import fopt.pp2020.lin.tag3.aufgabe4.interfaces.IMultiplier;
import fopt.pp2020.lin.tag3.aufgabe4.interfaces.ISubstractor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculator extends UnicastRemoteObject implements IAdder, IDivider, IMultiplier, ISubstractor
{
    private static final long serialVersionUID = 3872100835112569897L;

    public Calculator() throws RemoteException
    {
        super();
    }

    @Override
    public int substract(int a, int b) throws RemoteException
    {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) throws RemoteException
    {
        return a * b;
    }

    @Override
    public double divide(int a, int b) throws RemoteException
    {
        if(a <= 0 || b <= 0) return 0.0;
        return (double)a / (double)b;
    }

    @Override
    public int add(int a, int b) throws RemoteException
    {
        return a + b;
    }
}
