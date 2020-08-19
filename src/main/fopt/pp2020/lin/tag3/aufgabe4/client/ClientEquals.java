package fopt.pp2020.lin.tag3.aufgabe4.client;

import java.rmi.Naming;
import java.rmi.Remote;

public class ClientEquals
{
    public static void main(String args[])
    {
        if(args.length == 1)
        {
            try
            {
                // Verwenden Sie die static-Methode Naming.list, um die Namen aller in einer RMI-Registry aktuell angemeldeten RMI-Objekte abzufragen!
                String[] onlineRMIs = Naming.list("rmi://" + args[0] + "/Calculator");
                System.out.println("Found '" + onlineRMIs.length + "' different RMIs!");
                
                for(String singleRMI : onlineRMIs)
                {
                    System.out.println(singleRMI);
                }
                
                // Beschaffen Sie sich mit zwei Naming.lookup-Aufrufen zwei Stubs auf dasselbe RMI-Objekt! Ver�gleichen Sie die Stubs mit == und equals!
                System.out.println();
                System.out.println("Both objects are using rmi://" + args[0] + "/Calculator1 now!");
                
                Remote compareObject1 = Naming.lookup("rmi://" + args[0] + "/Calculator1");
                Remote compareObject2 = Naming.lookup("rmi://" + args[0] + "/Calculator1");
                
                if (compareObject1 == compareObject2)
                {
                    System.out.println("Both RMIs are identical (==) !");
                }
                else
                {
                    System.out.println("Both RMIs are NOT identical (==) !");
                }
                
                if (compareObject1.equals(compareObject2))
                {
                    System.out.println("Both RMIs are equal!");
                }
                else
                {
                    System.out.println("Both RMIs are NOT equal!");
                }
                
                // Beschaffen Sie sich mit zwei Naming.lookup-Aufrufen zwei Stubs auf die beiden unterschied�lichen RMI-Objekte! Vergleichen Sie auch diese Stubs mit == und equals!
                System.out.println();
                System.out.println("One object is using rmi://" + args[0] + "/Calculator1 and the other rmi://" + args[0] + "/Calculator2!");
                compareObject1 = Naming.lookup("rmi://" + args[0] + "/Calculator1");
                compareObject2 = Naming.lookup("rmi://" + args[0] + "/Calculator2");
                
                if (compareObject1 == compareObject2)
                {
                    System.out.println("Both RMIs are identical (==) !");
                }
                else
                {
                    System.out.println("Both RMIs are NOT identical (==) !");
                }
                
                if (compareObject1.equals(compareObject2))
                {
                    System.out.println("Both RMIs are equal!");
                }
                else
                {
                    System.out.println("Both RMIs are NOT equal!");
                }
            }
            catch(Exception e)
            {
                System.out.println("Exception occured: " + e.getMessage());
            }
        }
        else
        {
            System.out.println("No Server Address given!");
        }
    }
}
