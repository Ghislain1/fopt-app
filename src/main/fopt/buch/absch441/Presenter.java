package fopt.buch.absch441;

public class Presenter
{
    private Model model;

    private View view;

    private String text;

    public Presenter(View view, Model model)
    {
        if (model == null)
        {
            throw new IllegalArgumentException("model must be not null");
        }
        this.model = model;
        this.view = view;

    }

    private int howMuch;

    public boolean check()
    {
        this.howMuch++;
        String keyword = this.view.getKeyword();

        String response = this.model.getResponse(keyword);

        // User input
        String userResponse = this.view.getUserInputText();
        boolean isOkay = response.equals(userResponse);
        if (isOkay)
        {
            this.view.setStatusInfo("Prima!!");
        }
        else
        {
            this.view.setStatusInfo("Die Lösung war zum " + howMuch + " Mal Falsch");
        }

        return isOkay;

    }

    public void next()
    {
        String textToTranslate = this.model.choose();
        this.view.setText(textToTranslate);
    }

    public String getText()
    {
        return this.model.choose();
    }

}
