package fopt.pp2020.lin.tag3.aufgabe4.client;


import fopt.pp2020.lin.tag3.aufgabe4.interfaces.IAdder;
import fopt.pp2020.lin.tag3.aufgabe4.interfaces.IDivider;
import fopt.pp2020.lin.tag3.aufgabe4.interfaces.IMultiplier;
import fopt.pp2020.lin.tag3.aufgabe4.interfaces.ISubstractor;

import java.rmi.Naming;
import java.rmi.Remote;
import java.util.Scanner;

public class Client
{
    private static boolean exit = false;
    
    public static void main(String args[])
    {
        if(args.length == 1)
        {
            try
            {
                Remote onlineCalculator = Naming.lookup("rmi://" + args[0] + "/Calculator");
                Scanner inputScanner = new Scanner(System.in);
                
                while(!exit)
                {
                    String[] input = inputScanner.nextLine().split("\\s+");
                    
                    if(input.length == 3)
                    {
                        String command = input[0];
                        int para1 = Integer.parseInt(input[1]);
                        int para2 = Integer.parseInt(input[2]);
                        
                        switch(command)
                        {
                            case "add":
                                printResult("Performing '" + command + "' on " + para1 + " and " + para2 + "!", ((IAdder) onlineCalculator).add(para1, para2));
                                break;
                            case "substract":
                                printResult("Performing '" + command + "' on " + para1 + " and " + para2 + "!", ((ISubstractor) onlineCalculator).substract(para1, para2));
                                break;
                            case "multiply":
                                printResult("Performing '" + command + "' on " + para1 + " and " + para2 + "!", ((IMultiplier) onlineCalculator).multiply(para1, para2));
                                break;
                            case "divide":
                                printResult("Performing '" + command + "' on " + para1 + " and " + para2 + "!", ((IDivider) onlineCalculator).divide(para1, para2));
                                break;
                            default:
                                System.out.println("'" + command + "' is not a valid operation!");
                                break;
                        }
                    }
                    
                    if(input[0].equalsIgnoreCase("exit"))
                    {
                        exit = true;
                    }
                }
                
                inputScanner.close();
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
    
    private static void printResult(String text, double result)
    {
        System.out.println(text + " Result: " + result);
    }
}
