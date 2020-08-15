package fopt.buch.abschn55;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AusgabePipeline
{

    public static void main(String[] args) throws IOException
    {

        // TODO@GHis: Ausgabe Pipeline fuer ein Int-Wert? Bild 5.7 not works
        // why? fush?
        int intWert = 65;
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File("z1Ghislain.x")))
        {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            try (DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream))
            {
                dataOutputStream.writeInt(intWert);
                dataOutputStream.writeInt(65);
                bufferedOutputStream.flush(); // Wichtig!!!
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            System.out.println("**************** Resouerces released***************");
        }
    }

}
