package gui.graphics.sinus;

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
    private Double x0 = 900D;

    private Double y0 = 500D;

    private double xCenter;

    private double yCenter;

    private Slider amplitudeSlider;

    private Slider frequencySlider;

    private Slider phaseSlider;

    private Pane graphPane;

    private Label labelFunction;

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

    public void draw(double amplitude, double frequency, double phase, double zoom)
    {
        int numberOfPoints = 10;
        Double[] points = new Double[numberOfPoints];

        double deltaX = 1;
        double x = xCenter;
        double y = 0;
        int index = 0;
        int start = -10;
        int end = 9;
        double ds = end - start / numberOfPoints;

        do
        {
            // Berechnen
            x = ds + x - xCenter;
            y = amplitude * Math.sin(frequency * x + phase);
            System.out.println(x);
            // Storage
            points[index] = x;
            points[index + 1] = y;

            index += 2;

        }
        while (index < numberOfPoints - 1);

        int count = 0;
        for (double db : points)
        {
            if (count % 2 == 0)
            {
                // System.out.println(" (" + points[count] + " , " +
                // points[count + 1] + ")");
            }
            count++;

        }

        this.polyline.getPoints().clear();
        this.polyline.getPoints().addAll(points);
        this.polyline.setStroke(Color.BLACK);
        this.polyline.setStrokeWidth(1);
        this.polyline.setScaleZ(zoom);

    }

    private void initUi()
    {
        // JavaFx Elemente: wir haben in GUI 6 Haupt-Elemente
        this.labelFunction = new Label();
        this.polyline = new Polyline();
        Polyline xPolyline = new Polyline(x0 / 2, 0, x0 / 2, y0);
        Polyline yPolyline = new Polyline(0, y0 / 2, x0, y0 / 2);
        this.amplitudeSlider = new Slider(-6, 6, 0.57);
        this.phaseSlider = new Slider(-10, 10, 0);
        this.frequencySlider = new Slider(0, 40, 2.09);
        this.zoomSlider = new Slider(10, 210, 50); // min, max and cuurent value
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

        this.frequencySlider.setShowTickMarks(true); // TicMarks anzuzeigen in
        this.frequencySlider.setShowTickLabels(true);
        this.frequencySlider.setSnapToTicks(true);
        this.frequencySlider.setMajorTickUnit(10);

        this.phaseSlider.setShowTickMarks(true); // TicMarks anzuzeigen in
        this.phaseSlider.setShowTickLabels(true);
        this.phaseSlider.setSnapToTicks(true);
        this.phaseSlider.setMajorTickUnit(5);

        this.zoomSlider.setShowTickMarks(true); // TicMarks anzuzeigen in
        this.zoomSlider.setShowTickLabels(true);
        this.zoomSlider.setSnapToTicks(true);
        this.zoomSlider.setMajorTickUnit(5);

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
        this.frequencySlider.valueProperty().addListener((s, x, dxs) -> this.sinusPresenter.onFrequencyChanged(s, x, dxs));
        this.phaseSlider.valueProperty().addListener((s, x, dxs) -> this.sinusPresenter.onPhaseChanged(s, x, dxs));
        this.zoomSlider.valueProperty().addListener((s, x, dxs) -> this.sinusPresenter.onZoomChanged(s, x, dxs));// Set
        this.scene = new Scene(root, 900, 500);
        this.xCenter = this.scene.getWidth() / 2;
        this.yCenter = this.scene.getHeight() / 2;

    }

    public void updateFunctionDef(String functionText)
    {
        this.labelFunction.setText(functionText);
    }

    // 1. Using FXCollections.observableArrayList(Array)
    // 2. initUI() und getUI()
    // 3. Presenter wird uebergeben.

}
