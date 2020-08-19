package fopt.pp2020.lin.tag3;

import fopt.buch.abschn55.TCPSocket;
import fopt.buch.abschn55.TCPSocketImpl;

import java.net.Socket;

public class Slave extends Thread
{
    private Socket socket;

    public Slave(Socket socket)
    {
        this.socket = socket;
        this.start();
    }

    @Override
    public void run()
    {

        try (TCPSocket tcpSocket = new TCPSocketImpl(this.socket))
        {
            while (true)
            {
                String msg = tcpSocket.receiveLine();
                if (msg == null)
                {
                    break;
                }

                try
                {
                    int msgInterger = Integer.parseInt(msg);
                    // Sekundenschlaf
                    Thread.sleep(msgInterger * 1000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                // PONG msg
                tcpSocket.sendLine(msg);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

    }
}
