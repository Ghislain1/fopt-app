package fopt.buch.abschn64;

import java.io.Serializable;

public class ListItem implements Serializable
{
    private int value;

    private ListItem next;

    public ListItem(int value)
    {
        this.value = value;
    }

    public ListItem getNext()
    {
        return next;
    }

    public void setNext(ListItem next)
    {
        this.next = next;
    }

    public int getValue()
    {
        return this.value;
    }

}
