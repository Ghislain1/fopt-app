package fopt.video.rmi.sleep;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

// TODO@GHZE Extends Remote weil wir fern steuern wollen.
public interface Sleep extends Remote, Serializable
{
    public void sleep(int secs) throws RemoteException;
}
