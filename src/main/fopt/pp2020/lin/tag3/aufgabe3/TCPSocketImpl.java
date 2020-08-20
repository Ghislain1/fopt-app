package fopt.pp2020.lin.tag3.aufgabe3;

import fopt.pp2020.lin.tag3.aufgabe3.lehrbuch.TCPSocket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPSocketImpl implements TCPSocket
{
    private Socket socket;

    // TODO@GHZe: Check formelsammlung warum diese Deklaration
    private BufferedWriter bw;

    private BufferedReader br;

    private OutputStream os;

    // Used by Server
    public TCPSocketImpl(Socket socket) throws IOException
    {
        this.socket = socket;
        this.br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public TCPSocketImpl(String host, int serverPort) throws UnknownHostException, IOException
    {
        this(new Socket(host, serverPort));
    }

    @Override
    public void close() throws Exception
    {
        if (this.socket == null)
        {
            throw new Exception(" socket is null");
        }
        // bw.close();
        // os.close();
        this.socket.close();
        System.out.println("*************SOCKET CLOSED*******************");

    }

    @Override
    public void sendLine(String mgs) throws IOException
    {
        // TODO@Ghze: How to send a string-Value over TCP using JAVA-Socket
        bw.write(mgs);
        bw.newLine();

        // TODO@hisZe. Warum fush() is wichtig?
        bw.flush();

    }

    @Override
    public String receiveLine() throws IOException
    {
        // TODO@Ghze: How to receive a string-Value over TCP using JAVA-Socket
        // --

        return br.readLine();

    }

}
