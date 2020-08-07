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
        this.sinusView.updateFunctionDef(this.sinusModel.getFunctionDef());
        this.sinusView.draw(this.sinusModel.getAmplitude(), this.sinusModel.getFrequency(), this.sinusModel.getPhase(), this.sinusModel.getZoom());
    }

    public void onAmplitudeChanged(ObservableValue<? extends Number> s, Number newValue, Number oldValue)
    {
        this.sinusModel.setAmplitude(newValue.doubleValue());
        this.updateUI();
    }

    public void onFrequencyChanged(ObservableValue<? extends Number> s, Number newV, Number old)
    {
        this.sinusModel.setFrequency(newV.doubleValue());
        this.updateUI();
    }

    public void onZoomChanged(ObservableValue<? extends Number> s, Number newV, Number old)
    {
        this.sinusModel.setZoom(newV.doubleValue());
        this.updateUI();
    }

    public void onPhaseChanged(ObservableValue<? extends Number> s, Number newV, Number old)
    {
        this.sinusModel.setPhase(newV.doubleValue());
        this.updateUI();

    }

    private void updateUI()
    {
        this.sinusView.updateFunctionDef(this.sinusModel.getFunctionDef());
        this.sinusView.draw(sinusModel.getAmplitude(), sinusModel.getFrequency(), sinusModel.getPhase(), sinusModel.getZoom());
    }

}
