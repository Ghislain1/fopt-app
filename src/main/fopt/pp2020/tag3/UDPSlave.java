package fopt.pp2020.tag3;

public class UDPSlave extends Thread
{
    private final UDPSocket udpSocket;

    public UDPSlave(UDPSocket udpSocket)
    {
        this.udpSocket = udpSocket;
        this.start();
    }

    @Override
    public void run()
    {

        try
        { // receive request
            String request = udpSocket.receive(20);

            // FAKE WORK
            Thread.sleep(1000 * 5);

            // generate answer
            String answer = request + " " + udpSocket.getSenderAddress() + ":" + udpSocket.getSenderPort();
            // send answer
            udpSocket.reply(answer);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
