package fopt.pp2020.lin.tag3.aufgabe3;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPSocketAdvancedImpl implements TCPSocketAdvance
{


    private Socket socket;

    // TODO@GHZe: Check formelsammlung warum diese Deklaration
//    private BufferedWriter bw;
//
//    private BufferedReader br;

//    private OutputStream os;

    private DataInputStream dis;

    private DataOutputStream dos;

    // Used by Server
    public TCPSocketAdvancedImpl(Socket socket) throws IOException
    {
        this.socket = socket;
//        this.br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
//        this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        this.dis = new DataInputStream(socket.getInputStream());
        this.dos = new DataOutputStream(socket.getOutputStream());
    }

    public TCPSocketAdvancedImpl(String host, int serverPort) throws UnknownHostException, IOException
    {
        this(new Socket(host, serverPort));
    }

    @Override
    public void close() throws Exception
    {
        if(dos!=null){
            dos.close();
        }
        if(dis!=null){
            dis.close();
        }
        if (socket == null)
        {
            throw new Exception(" socket is null");
        }
        this.socket.close();
        System.out.println("*************SOCKET CLOSED*******************");

    }

    @Override
    public void sendLine(Object o) throws IOException {
        dos.writeUTF(o.toString());
        dos.flush();
    }


    @Override
    public String receiveLine() throws IOException
    {
        return dis.readUTF();
    }

}
