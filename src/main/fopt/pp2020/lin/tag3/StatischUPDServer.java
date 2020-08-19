package fopt.pp2020.lin.tag3;

public class StatischUPDServer
{

    public static void main(String[] args)
    {
        boolean isRunning = true;
        while (isRunning)
        {

            try (UDPSocket udpSocket = new UDPSocket(1250))
            {
                System.out.println("Server>> wartet!! ..");
                // there may be more than one thread by using foreach
                new Thread(new StatischUDPSocketThread(udpSocket, 20)).start();
            }
            catch (Exception socketException)
            {
                isRunning = false;
                socketException.printStackTrace();
            }

        }
    }

}
