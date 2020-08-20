package fopt.pp2020.lin.tag3.aufgabe3.lehrbuch;

import fopt.pp2020.lin.tag3.aufgabe3.TCPSocketImpl;

public class TCPClient
{

    public static void main(String[] args)
    {
        try (TCPSocket tcpSocket = new TCPSocketImpl("127.0.0.1", 4200))
        {
            tcpSocket.sendLine("reset");

            String resp = tcpSocket.receiveLine();
            System.out.println("Client>> Counter= " + resp);
            for (int i = 0; i < 200; i++)
            {
                tcpSocket.sendLine("increment");
                System.out.println("Client>> Counter= " + tcpSocket.receiveLine());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
