package gui.graphics.sinus;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SinusView
{
    private Slider amplitudeSlider;

    private Slider frequencySlider;

    private Slider phaseSlider;

    private Slider zoomSlider;

    private SinusPresenter sinusPresenter;

    public void setPresenter(SinusPresenter sinusPresenter)
    {
        this.sinusPresenter = sinusPresenter;

    }

    public Scene getUi()
    {
        // „amplitude“, „frequency“, „phase“ und „zoom“ besitzen.

        // JavaFx Elements
        this.amplitudeSlider = new Slider();
        this.phaseSlider = new Slider();
        this.frequencySlider = new Slider();
        this.zoomSlider = new Slider();

        // Set ids
        this.amplitudeSlider.setId("amplitude");
        this.frequencySlider.setId("frequency");
        this.phaseSlider.setId("phase");
        this.zoomSlider.setId("zoom");

        // Set Range
        this.amplitudeSlider.setMin(-6);
        this.amplitudeSlider.setMax(6);

        // arrange element
        VBox vbox = new VBox();
        HBox amplitudeHBox = new HBox();
        amplitudeHBox.getChildren().add(new Label("Amplitude"));
        amplitudeHBox.getChildren().add(this.amplitudeSlider);

        HBox frequencyHBox = new HBox();
        frequencyHBox.getChildren().add(new Label("Frequency"));
        frequencyHBox.getChildren().add(this.frequencySlider);

        HBox phaseHBox = new HBox();
        phaseHBox.getChildren().add(new Label("Phase"));
        phaseHBox.getChildren().add(this.phaseSlider);

        HBox zoomHBox = new HBox();
        zoomHBox.getChildren().add(new Label("Zoom"));
        zoomHBox.getChildren().add(this.zoomSlider);

        // Arrange in BorderPane
        BorderPane root = new BorderPane();
        Label labelFunction = new Label("11* sin(123*x +100)");
        root.setTop(labelFunction);
        root.setBottom(vbox);
        vbox.getChildren().add(amplitudeHBox);
        vbox.getChildren().add(frequencyHBox);
        vbox.getChildren().add(phaseHBox);
        vbox.getChildren().add(zoomHBox);

        return new Scene(root, 620, 300);

    }
}
