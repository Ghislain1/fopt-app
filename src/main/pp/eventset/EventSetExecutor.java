package pp.eventset;

public class EventSetExecutor
{

    public static void main(String[] args)
    {
        // System.out.println("Start App !!!");
        EventSet eventSet = new EventSet(5);

        // new EventSetThread(eventSet);
        Thread threadANDCaller = new Thread(() ->
        {
            eventSet.waitAND();
        });
        threadANDCaller.start();

        Thread threadOrCaller = new Thread(() ->
        {
            eventSet.waitOR();
        });
        threadOrCaller.start();

        new EventSetThread(eventSet);
    }

}
