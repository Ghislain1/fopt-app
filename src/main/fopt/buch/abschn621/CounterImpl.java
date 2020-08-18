package fopt.buch.abschn621;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//1.Warum muessen wir die Klasse UnicastRemotObject ableiten?
public class CounterImpl extends UnicastRemoteObject implements Counter
{
    int count;

    protected CounterImpl() throws RemoteException
    {
        super();

    }

    // TODO@GHZE 2. warum muessen wir die Methoden mit synchronized
    // kenntzeichen?
    @Override
    public synchronized int reset() throws RemoteException
    {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread + " calls reset method, Count was = " + this.count);
        this.count = 0;
        return this.count;
    }

    @Override
    public synchronized int increment() throws RemoteException
    {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread + " calls increment() method ");
        this.count++;
        return this.count;
    }

}

// 1. Damit ein Objekt dieser Klasse exporiert wrden kann, somit mit RMI benutzt
// werden kann.
// 2. Somit sind wir darauf vorbereitet, dass ein Objekt dieser Klasse
// gleichzeitig von mehreren Client verwendet koennen werden.
// mehreren Client