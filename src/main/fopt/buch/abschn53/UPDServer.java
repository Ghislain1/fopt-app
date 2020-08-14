package fopt.buch.abschn53;

public class UPDServer
{

    public static void main(String[] args)
    {
        // Model
        int counter = -99;

        int serverNumber = 0;
        while (serverNumber < 222)
        {
            serverNumber++;
            try (UDPSocket udpSocket = new UDPSocket(1250))
            {
                System.out.println("Server>> wartet!! ..");
                String request = udpSocket.receive(20);

                if (request.trim().equals("reset"))
                {
                    counter = 0;
                    System.out.println("Server>> " + udpSocket.getClientIp() + ":" + udpSocket.getClientPort() + " (RESET)");
                }
                else if (request.trim().equals("increment"))
                {
                    counter++;
                    System.out.println("Server>>  " + udpSocket.getClientIp() + ":" + udpSocket.getClientPort() + " (INCREMENT)");

                }
                else
                {
                    System.out.println(request.equals("reset"));
                }

                // generate response

                String messageToClient = String.valueOf(counter);
                udpSocket.reply(messageToClient);

            }
            catch (Exception socketException)
            {
                socketException.printStackTrace();
            }

        }
    }

}
