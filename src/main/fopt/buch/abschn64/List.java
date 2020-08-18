package fopt.buch.abschn64;

import java.io.Serializable;

public class List implements Serializable
{
    private ListItem first;

    private ListItem last;

    public void append(int value)
    {
        if (first == null)
        {
            first = new ListItem(value);
            this.last = first;
        }
        else
        {
            ListItem newItem = new ListItem(value);

            this.last.setNext(newItem);
            this.last = this.last.getNext();

        }
    }

    public void print()
    {
        System.out.println();
        ListItem listItem = this.first;
        while (listItem != null)
        {
            System.out.print(listItem.getValue() + " ");
            listItem = listItem.getNext();
        }
        System.out.println();
    }
}
