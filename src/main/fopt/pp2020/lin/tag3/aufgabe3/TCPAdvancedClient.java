package fopt.pp2020.lin.tag3.aufgabe3;

public class TCPAdvancedClient
{

    public static void main(String[] args)
    {
        try (TCPSocketAdvance tcpSocket = new TCPSocketAdvancedImpl("127.0.0.1", 4200))
        {
            tcpSocket.sendLine("reset");

            String resp = tcpSocket.receiveLine();
            System.out.println("Client>> Counter= " + resp);
            for (int i = 0; i < 200; i++)
            {
                tcpSocket.sendLine(i);
                System.out.println("Client>> Counter= " + tcpSocket.receiveLine());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
