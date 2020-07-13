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
        System.out.println(newValue + "  Zoom Aplite " + oldValue);
        this.sinusView.updateAmplitude(Double.valueOf(newValue + ""));

    }

}
