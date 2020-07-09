package pp.filelocking;

public class UnlockThread extends Thread
{
    private File file;

    public UnlockThread(File file)
    {
        this.file = file;
        this.start();
    }

    @Override
    public void run()
    {
        for (int k = 0; k < 1000; k++)
        {
            this.file.unlock(k, k + 1);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            this.file.unlock(10, 14);
        }
    }
}
