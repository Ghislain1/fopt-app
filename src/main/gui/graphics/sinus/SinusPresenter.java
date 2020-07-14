package gui.graphics.sinus;

import javafx.beans.value.ObservableValue;

public class SinusPresenter
{
    private SinusModel sinusModel;

    private SinusView sinusView;

    public SinusPresenter()
    {

    }

    public void setModelAndView(SinusView sinusView, SinusModel sinusModel)
    {
        this.sinusView = sinusView;
        this.sinusModel = sinusModel;
    }

    public void onAmplitudeChanged(ObservableValue<? extends Number> s, Number newValue, Number oldValue)
    {
        this.sinusView.updateFunction(newValue.doubleValue(), sinusModel.getFrequency(), sinusModel.getPhase(), sinusModel.getZoom());

    }

}
