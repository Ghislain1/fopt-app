package fopt.buch.abschn21;

//Eine Mölichkeit Java Thread zum Erzeugen und Starten
//Ableiten der Klasse Thread 
//Abschnitt 2.1.2 wird 2 Möglichkeiten gezeigt!! 
//Was ist lambda ausdruck?
public class Loop1 extends Thread
{

    // Name der jeweils Thread zu speichern.
    private String myName1;

    public Loop1(String name)
    {
	myName = name;
    }

    @Override
    public void run()
    {
	for (int i = 1; i <= 100; i++)
	{
	    System.out.println(myName + " (" + i + ")");
	}
    }

    public static void main(String[] args)
    {

	Loop1 t1 = new Loop1("Thread 1");
	Loop1 t2 = new Loop1("Thread 2");
	Loop1 t3 = new Loop1("Thread 3");

	// die Start-Methode erweckt t1, t2, t3 zum Leben.
	t1.start();
	t2.start();
	t3.start();
    }

}