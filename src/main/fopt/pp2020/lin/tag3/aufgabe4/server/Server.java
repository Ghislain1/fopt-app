package fopt.pp2020.lin.tag3.aufgabe4.server;


import fopt.pp2020.lin.tag3.aufgabe4.logic.Calculator;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server
{
    public static void main(String args[])
    {
        try
        {
            @SuppressWarnings("unused")
            Registry rmiRegistry = LocateRegistry.createRegistry(6060);
            System.setProperty("Java.rmi.server.hostname", "192.168.2.109");
            
            Calculator calculatorServer = new Calculator();
            Naming.rebind("rmi://192.168.2.109:6060/Calculator", calculatorServer);
            System.out.println("Calculator is started!");
        }
        catch(Exception e)
        {
            System.out.println("Exception occured: " + e.getMessage());
        }
    }
}
