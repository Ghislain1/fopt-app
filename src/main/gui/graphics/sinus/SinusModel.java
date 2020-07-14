package gui.graphics.sinus;

public class SinusModel
{
    private Double amplitude;

    private Double frequency;

    private Double zoom;

    private Double phase;

    public SinusModel(Double amplitude, Double frequency, Double phase, Double zoom)
    {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.phase = phase;
        this.zoom = zoom;
    }

    public Double getAmplitude()
    {
        return amplitude;
    }

    public void setAmplitude(Double amplitude)
    {
        this.amplitude = amplitude;
    }

    public Double getPhase()
    {
        return phase;
    }

    public void setPhase(Double phase)
    {
        this.phase = phase;
    }

    public Double getFrequency()
    {
        return frequency;
    }

    public void setFrequency(Double frequency)
    {
        this.frequency = frequency;
    }

    public Double getZoom()
    {
        return zoom;
    }

    public void setZoom(Double zoom)
    {
        this.zoom = zoom;
    }

}
