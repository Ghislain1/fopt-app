package fopt.pp2020.tag3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPSlave extends Thread
{
    private final DatagramSocket datagramSocket;

    private final DatagramPacket datagramPacket;

    public UDPSlave(DatagramSocket datagramSocket, DatagramPacket datagramPacket, int length)
    {
        this.datagramSocket = datagramSocket;
        this.datagramPacket = datagramPacket;
        this.start();
    }

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName() + " RUNNING ");
        try
        {

            // FAKE WORK
            Thread.sleep(1000 * 5);

            // generate answer
            String answer = "Hallo" + " " + this.datagramPacket.getAddress() + ":" + this.datagramPacket.getPort();
            // send answer

            DatagramPacket p = new DatagramPacket(answer.getBytes(), answer.getBytes().length, this.datagramPacket.getAddress(), this.datagramPacket.getPort());
            System.out.println(p.getLength());
            this.datagramSocket.send(p);
        }
        catch (Exception e)
        {

            e.printStackTrace();
        }

    }

}
