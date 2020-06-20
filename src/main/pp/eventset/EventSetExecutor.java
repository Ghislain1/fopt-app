package pp.eventset;

public class EventSetExecutor
{

    public static void main(String[] args)
    {
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
