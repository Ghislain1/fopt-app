package fopt.buch.abschn64;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * TODO@GHZe - Wertuebergabe bei RMI ist sinnvoll, wenn es nur rein lesende
 * Aufgabe druchgefuhrt werden soll. e.g. Specherung, Auswertung
 */
public interface Append extends Remote
{
    /**
     * List: ist eine Datenstruktur siehe Abschnitt 6.4.1
     **/
    public void tryToAppend(List listObject) throws RemoteException;

}
