package fopt.video.rmi.sleep;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class SleepClient
{

    public static void main(String[] args)
    {
        if (args.length < 3)
        {
            usage();
        }
        String url = "rmi://" + args[0] + "/" + args[1];
        int secondes = Integer.parseInt(args[2]);
        try
        {
            // Variable mit namen server dient fer besseres Verstaendnis --> Wer
            // hat den stub registriert?
            Sleep server = (Sleep) Naming.lookup(url);

            // Asynchron durchfuehren
            new Thread(() ->
            {
                doParrallelCall(server, 5);
            }).start();

            // Main thread called
            server.sleep(secondes);
        }
        catch (MalformedURLException | RemoteException | NotBoundException e)
        {

            e.printStackTrace();
        }

    }

    private static void doParrallelCall(Sleep server, int secs)
    {
        try
        {
            System.out.println("  ------------------------------------ ");
            server.sleep(secs);
            System.out.println("  ------------------------------------ ");

        }
        catch (RemoteException e)
        {

            e.printStackTrace();
        }

    }

    private static void usage()
    {
        System.err.println("java -verbose fopt.video.rmi.sleep.SleepClient <server-name> <stub-name> <seconde>");

    }

}
