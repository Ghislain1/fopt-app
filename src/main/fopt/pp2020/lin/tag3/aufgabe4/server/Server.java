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

            // if you test in your local pc, finde out the ip adress of it then replace the second parameter
            System.setProperty("Java.rmi.server.hostname", "192.168.0.81");
            
            Calculator calculatorServer = new Calculator();

            // if you test in your local pc, finde out the ip adress of it then replace the ip adress in first parameter
            Naming.rebind("rmi://192.168.0.81:6060/Calculator", calculatorServer);
            System.out.println("Calculator is started!");
        }
        catch(Exception e)
        {
            System.out.println("Exception occured: " + e.getMessage());
        }
    }
}
