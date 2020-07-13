package gui.graphics.sinus;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

// 1. Wie instanziert man ein ObservableList<Double>  object?
// 2. View-Teil hat immer 2 method? welhe  initUi() und 
// 3. View hat immer Paramterüberagbe in Constructor?

public class SinusView
{
    private Slider amplitudeSlider;

    private Slider frequencySlider;

    private Slider phaseSlider;

    Polyline polyline;

    private Slider zoomSlider;

    private Scene scene;

    private SinusPresenter sinusPresenter;

    public SinusView(SinusPresenter sinusPresenter)
    {
        this.sinusPresenter = sinusPresenter;
        this.initUi();
    }

    public Scene getUi()
    {
        return this.scene;
    }

    public void updateAmplitude(Double amplitude)
    {
        Double[] points = new Double[100 * 2];
        for (int i = 0; i < 100 * 2; i = i + 2)
        {
            points[i] = i * 1d;
            points[i + 1] = amplitude * Math.sin(8.83 * i + 46.4);

        }
        this.polyline = new Polyline();
        this.polyline.getPoints().addAll(points);
        this.polyline.setStroke(Color.BLACK);
        this.polyline.setStrokeWidth(1);
    }

    private void initUi()
    {
        // amplitude, frequency, phase und zoom besitzen.

        // JavaFx Elemente: wir haben in GUI 6 Haupt-Elemente
        Label labelFunction = new Label("11* sin(123*x +100)");
        Pane graph = new Pane();

        // test
        this.updateAmplitude(3.456);

        graph.getChildren().add(this.polyline);
        this.amplitudeSlider = new Slider(-6, 6, 1);
        this.phaseSlider = new Slider();
        this.frequencySlider = new Slider();
        this.zoomSlider = new Slider();

        // Set ids
        this.amplitudeSlider.setId("amplitude");
        this.frequencySlider.setId("frequency");
        this.phaseSlider.setId("phase");
        this.zoomSlider.setId("zoom");

        // Set Properties
        this.amplitudeSlider.setShowTickMarks(true); // TicMarks anzuzeigen in
        this.amplitudeSlider.setMajorTickUnit(1);
        this.amplitudeSlider.setShowTickLabels(true);

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
        root.setTop(labelFunction);
        root.setCenter(graph);
        root.setBottom(vbox);
        vbox.getChildren().add(amplitudeHBox);
        vbox.getChildren().add(frequencyHBox);
        vbox.getChildren().add(phaseHBox);
        vbox.getChildren().add(zoomHBox);

        // Handler
        // this.amplitudeSlider.valueProperty().addListener((oldValue, newValue)
        // -> this.sinusPresenter.onAmplitudeZoom(oldValue, newValue));
        this.amplitudeSlider.valueProperty().addListener((s, x, dxs) -> this.sinusPresenter.onAmplitudeChanged(s, x, dxs));
        // Set up x, y Axes

        this.scene = new Scene(root, 620, 300);

    }
    // 1. Using FXCollections.observableArrayList(Array)
    // 2. initUI() und getUI()
    // 3. Presenter wird uebergeben.
}
