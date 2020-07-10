package gui.graphics.sinus;

public class SinusPresenter
{
    private SinusModel sinusModel;

    private SinusView sinusView;

    public SinusPresenter(SinusView sinusView, SinusModel sinusModel)
    {
        this.sinusView = sinusView;
        this.sinusModel = sinusModel;
    }

}
