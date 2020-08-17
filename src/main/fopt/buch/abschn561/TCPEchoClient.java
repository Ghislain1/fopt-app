package fopt.buch.abschn561;

import fopt.buch.abschn55.TCPSocket;
import fopt.buch.abschn55.TCPSocketImpl;

public class TCPEchoClient
{
    public void sendMessage(String mgs)
    {
        // Verbindungaufbau
        try (TCPSocket tcpSocket = new TCPSocketImpl("localhost", 1250))
        {
            tcpSocket.sendLine(mgs);

            String reponse = tcpSocket.receiveLine();
            // System.out.println("PONG " + reponse);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= Integer.parseInt(args[0]); i++)
        {
            new TCPEchoClient().sendMessage("6");
        }

        // TODO@GhZe: How to Rechenzeit berechnen?
        long endTime = System.currentTimeMillis();
        float time = (endTime - startTime) / 1000.0f;
        System.out.println("Fuer " + Integer.parseInt(args[0]) + " Client  Schlafenzeit: " + time);
    }

}
