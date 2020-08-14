package fopt.buch.abschn53;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSocket implements AutoCloseable
{
    private DatagramSocket datagramSocket;

    private InetAddress targetAddress;

    private int targetPort;

    // Usage by client
    public UDPSocket() throws SocketException
    {
        this(new DatagramSocket());
        this.targetAddress = this.datagramSocket.getInetAddress();
        this.targetPort = this.datagramSocket.getPort();
    }

    // Usage by Server
    public UDPSocket(int localPort) throws SocketException
    {
        this(new DatagramSocket(localPort));
    }

    // Diese Konstrukto vermeiden duplicate of code hier zur Zuweisung von
    // dataGramSocket
    protected UDPSocket(DatagramSocket datagramSocket)
    {
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void close() throws Exception
    {
        if (this.datagramSocket != null)
        {
            this.datagramSocket.close();
            System.out.println("******************** SOCKET CLOSED************************");
        }

    }

    public String receive(int maxByte) throws IOException
    {
        byte[] bytes = new byte[maxByte];
        DatagramPacket p = new DatagramPacket(bytes, maxByte);
        this.datagramSocket.receive(p);
        this.targetAddress = p.getAddress();
        this.targetPort = p.getPort();

        return new String(bytes);
    }

    public void send(String msg, InetAddress ip, int port) throws IOException
    {
        byte[] buf = msg.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, ip, port);
        this.datagramSocket.send(datagramPacket);

    }

    public void reply(String response) throws IOException
    {
        if (this.targetAddress == null)
        {
            return;
        }
        this.send(response, this.targetAddress, this.targetPort);

    }

    public String getClientIp()
    {
        return this.targetAddress.getHostAddress();
    }

    public int getClientPort()
    {
        return this.targetPort;
    }

    public void setSoTimeout(int timeout) throws SocketException
    {
        this.datagramSocket.setSoTimeout(timeout);
    }
}
