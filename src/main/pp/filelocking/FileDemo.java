package pp.filelocking;

public class FileDemo
{

    public static void main(String[] args)
    {
        File file = new File(1000);
        UnlockThread unlockThread = new UnlockThread(file);
        LockThread lockThread = new LockThread(file);

        try
        {
            unlockThread.join();
            lockThread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Alle Threads sind abgeschlossen");
    }

}
