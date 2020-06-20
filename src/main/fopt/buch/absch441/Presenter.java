package fopt.buch.absch441;

public class Presenter
{
    private Model model;

    public Presenter(Model model)
    {
        if (model == null)
        {
            throw new IllegalArgumentException("model must be not null");
        }
        this.model = model;
    }

    public void check()
    {

    }

    public void next()
    {

    }

}
