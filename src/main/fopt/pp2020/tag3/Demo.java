package fopt.pp2020.tag3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//TODO@GhZe: warum e ein extra interface, Aufgabensetllung spricht von Kasse Demo
public class Demo extends UnicastRemoteObject implements IDemo
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected Demo() throws RemoteException
    {
        super();
    }

    // Warum synchronized siehe Buch: hier nicht so relevant
    @Override
    public synchronized void increment(Data data) throws RemoteException
    {
        int value = data.getValue();
        value++;
        data.setValue(value);

    }
}
