package pp.filelocking;

public class LockThread extends Thread
{
    private File file;

    public LockThread(File file)
    {
        this.file = file;
        this.start();
    }

    @Override
    public void run()
    {

        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        this.file.lock(10, 14);
    }
}
