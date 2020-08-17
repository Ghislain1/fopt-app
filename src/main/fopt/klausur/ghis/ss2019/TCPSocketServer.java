package fopt.klausur.ghis.ss2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketServer
{

    public static void main(String[] args)
    {
        try (ServerSocket socketServer = new ServerSocket(7777))
        {
            while (true)
            {
                System.out.println("************** Server listening **********************");
                try (Socket socket = socketServer.accept())
                {
                    socket.getOutputStream();

                    // Aus Formelsammlung lesen
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    while (true)
                    {
                        // Jeweils Zeile lesen
                        String request = br.readLine();

                        // Check end of line --> request == "EOL" ||
                        if (request == null)
                        {
                            break;
                        }

                        // Append the zeilen to builder
                        sb.append(request + "\n");

                    }
                    // Ausgabe auf der Console
                    System.out.print(sb.toString());
                }
                catch (Exception ewx)
                {
                    ewx.printStackTrace();
                }

            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }

    }

}
