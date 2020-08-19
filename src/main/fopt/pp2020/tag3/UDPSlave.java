package fopt.pp2020.tag3;

public class UDPSlave extends Thread
{
    private final UDPSocket udpSocket;

    private final String request;

    public UDPSlave(UDPSocket udpSocket, String request)
    {
        this.udpSocket = udpSocket;
        this.request = request;
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
            String answer = request + " " + udpSocket.getSenderAddress() + ":" + udpSocket.getSenderPort();
            // send answer
            udpSocket.reply(answer);
        }
        catch (Exception e)
        {

            e.printStackTrace();
        }

    }

}
