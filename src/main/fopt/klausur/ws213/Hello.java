package fopt.klausur.ws213;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote
{
    public String hello(String name) throws RemoteException;
}
