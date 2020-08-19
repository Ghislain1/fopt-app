package fopt.pp2020.lin.tag3.aufgabe4.client;

import java.rmi.Naming;
import java.rmi.Remote;

import rmi.interfaces.IMultiplier;
import rmi.logic.Calculator;

public class ClientMultiply
{
    public static void main(String args[])
    {
        if(args.length == 1)
        {
            try
            {
                Remote onlineCalculator = Naming.lookup("rmi://" + args[0] + "/Calculator");
                
                for(int a = 1; a <= 10; a++)
                {
                    for(int b = 1; b <= 10; b++)
                    {
                        printResult("Performing multiply on " + a + " and " + b + "!", ((IMultiplier) onlineCalculator).multiply(a, b));                        
                    }
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
    
    private static void printResult(String text, int result)
    {
        System.out.println(text + " Result: " + result);
    }
}
