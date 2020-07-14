package gui.graphics.sinus;

import java.text.DecimalFormat;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;

// 1. Wie instanziert man ein ObservableList<Double>  object?
// 2. View-Teil hat immer 2 method? welhe  initUi() und 
// 3. View hat immer Paramterueberagbe in Constructor?

public class SinusView
{
    private Slider amplitudeSlider;

    private Slider frequencySlider;

    private static DecimalFormat df = new DecimalFormat("0.00");

    private Slider phaseSlider;

    private Pane graphPane;

    private Label labelFunction;

    Polyline polyline;

    private Slider zoomSlider;

    private Scene scene;

    private Double x0 = 900D;

    private Double y0 = 500D;

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

    public void updateFunction(Double amplitude, Double frequency, Double phase, Double zoom)
    {
        Double[] points = new Double[100 * 2];
        for (int i = 0; i < 100 * 2; i = i + 2)
        {
            points[i] = x0 - i * 1D;
            points[i + 1] = y0 - (amplitude * Math.sin(8.83 * i + 46.4) * 1D);

            System.out.println("(" + points[i] + " , " + points[i + 1] + ")");
        }

        this.polyline.getPoints().clear();
        this.polyline.getPoints().addAll(points);
        this.polyline.setStroke(Color.BLACK);
        this.polyline.setStrokeWidth(1);

        this.labelFunction.setText(df.format(amplitude) + "* sin(" + df.format(2 * Math.PI * frequency) + "*x +" + df.format(phase) + ")");

    }

    private void initUi()
    {
        // JavaFx Elemente: wir haben in GUI 6 Haupt-Elemente
        this.labelFunction = new Label();
        this.polyline = new Polyline();
        Polyline xPolyline = new Polyline(x0 / 2, 0, x0 / 2, y0);
        Polyline yPolyline = new Polyline(0, y0 / 2, x0, y0 / 2);
        this.amplitudeSlider = new Slider(-6, 6, 1);
        this.phaseSlider = new Slider();
        this.frequencySlider = new Slider();
        this.zoomSlider = new Slider();
        Label amplitudeLabel = new Label("Amplitude:");
        Label phaseLabel = new Label("Phase:");
        Label frequencyLabel = new Label("Frequency:");
        Label zoomLabel = new Label("Zoom:");

        // Set ids
        this.amplitudeSlider.setId("amplitude");
        this.frequencySlider.setId("frequency");
        this.phaseSlider.setId("phase");
        this.zoomSlider.setId("zoom");

        // Set Font Size
        Font fontSize = Font.font(20);
        labelFunction.setFont(fontSize);
        amplitudeLabel.setFont(fontSize);
        phaseLabel.setFont(fontSize);
        frequencyLabel.setFont(fontSize);
        zoomLabel.setFont(fontSize);

        // Set Properties
        this.amplitudeSlider.setShowTickMarks(true); // TicMarks anzuzeigen in
        this.amplitudeSlider.setMajorTickUnit(1);
        this.amplitudeSlider.setShowTickLabels(true);
        this.amplitudeSlider.setSnapToTicks(true);

        // Containers definition
        BorderPane root = new BorderPane();
        this.graphPane = new Pane();
        VBox sinParamterVBox = new VBox();
        HBox amplitudeHBox = new HBox();
        HBox frequencyHBox = new HBox();
        HBox phaseHBox = new HBox();
        HBox zoomHBox = new HBox();

        // Arrange Elements in Containers
        graphPane.getChildren().add(this.polyline);
        graphPane.getChildren().add(xPolyline);
        graphPane.getChildren().add(yPolyline);

        amplitudeHBox.getChildren().add(amplitudeLabel);
        amplitudeHBox.getChildren().add(this.amplitudeSlider);
        frequencyHBox.getChildren().add(frequencyLabel);
        frequencyHBox.getChildren().add(this.frequencySlider);
        phaseHBox.getChildren().add(phaseLabel);
        phaseHBox.getChildren().add(this.phaseSlider);
        zoomHBox.getChildren().add(zoomLabel);
        zoomHBox.getChildren().add(this.zoomSlider);

        root.setTop(labelFunction);
        root.setCenter(graphPane);
        root.setBottom(sinParamterVBox);
        Insets padding = new Insets(10);
        sinParamterVBox.setPadding(padding);

        sinParamterVBox.getChildren().add(amplitudeHBox);
        sinParamterVBox.getChildren().add(frequencyHBox);
        sinParamterVBox.getChildren().add(phaseHBox);
        sinParamterVBox.getChildren().add(zoomHBox);

        // Handlers
        this.amplitudeSlider.valueProperty().addListener((s, x, dxs) -> this.sinusPresenter.onAmplitudeChanged(s, x, dxs));
        // Set up x, y Axes

        this.scene = new Scene(root, 900, 500);

    }
    // 1. Using FXCollections.observableArrayList(Array)
    // 2. initUI() und getUI()
    // 3. Presenter wird uebergeben.
}
