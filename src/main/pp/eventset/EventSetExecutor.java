package pp.eventset;

public class EventSetExecutor
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        EventSet eventSet = new EventSet(5);

        new EventSetThread(eventSet);
        new EventSetThread(eventSet);
        new EventSetThread(eventSet);

    }

}
