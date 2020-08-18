package fopt.pp2020.tag2;

public class Presenter
{
    private Model model;

    private View view;

    public void check(String name, boolean selected)
    {

        this.model.setSelected(name, selected);

        this.view.updateTotalWeight(this.model.getSumOfUsedWeights());
        this.view.updateEnabledItems(this.model.getEnabledItems());

    }

    public void setModelAndView(Model model, View view)
    {
        this.model = model;
        this.view = view;

    }

}
