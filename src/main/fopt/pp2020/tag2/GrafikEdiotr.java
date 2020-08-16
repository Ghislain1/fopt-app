package fopt.pp2020.tag2;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GrafikEdiotr extends Application
{

    // Startpoint einer Linie
    private double startX;

    Label labelProtocol;

    Pane grafikPane;

    List<Line> lineList;

    private Circle circle;

    private Line line;

    private Rectangle rectangle;

    private List<Circle> circleList;

    private List<Line> linien;

    private List<Circle> kreise;

    private List<Rectangle> rechtecke;

    String selectedRadioButtonText;

    private double startY;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Aufbau der Oberflaeche!!
        Pane pane = this.getUI();

        // Fenster anzeigen
        primaryStage.setScene(new Scene(pane, 500, 300));
        primaryStage.setTitle("Zeichen von Formen");
        primaryStage.show();
    }

    private Pane getUI()
    {
        // Inits Elements
        BorderPane root = new BorderPane();
        this.grafikPane = new Pane();
        RadioButton lineRadioButton = new RadioButton("Linie");
        RadioButton kreisRadioButton = new RadioButton("Kreis");
        RadioButton rechtteckRadioButton = new RadioButton("Rechtteck");
        ToggleGroup toggleGroup = new ToggleGroup();

        HBox hbox = new HBox(); // Container NUR fuer RadionsButtons

        this.labelProtocol = new Label("");

        // RadioButtons zusammenfassen
        toggleGroup.getToggles().addAll(lineRadioButton, kreisRadioButton, rechtteckRadioButton);

        // Properties setzen
        lineRadioButton.setSelected(true);
        this.selectedRadioButtonText = "Linie";
        this.lineList = new ArrayList<>();
        this.linien = new ArrayList<>();
        this.kreise = new ArrayList<>();
        this.rechtecke = new ArrayList<>();

        // Anordnen
        lineRadioButton.setPadding(new Insets(1.5));
        kreisRadioButton.setPadding(new Insets(1.5));
        rechtteckRadioButton.setPadding(new Insets(1.5));
        hbox.getChildren().addAll(lineRadioButton, kreisRadioButton, rechtteckRadioButton);
        root.setTop(hbox);
        root.setCenter(this.grafikPane);
        root.setBottom(this.labelProtocol);

        // Handlers fuer Containers
        grafikPane.setOnMousePressed(e ->
        {
            // Mouseposition relativ zur Quelle de Ereignisses
            this.startX = e.getX();
            this.startY = e.getY();

        });
        grafikPane.setOnMouseReleased(e ->
        {

            double lastPositionX = e.getX();
            double lastPositionY = e.getY();
            if (this.selectedRadioButtonText.equals("Linie"))
            {
                this.drawLine(lastPositionX, lastPositionY, Color.BLACK, 2);
            }
            else if (this.selectedRadioButtonText.equals("Kreis"))
            {
                drawCircle(lastPositionX, lastPositionY, Color.BLACK, 2);
                this.kreise.add(this.circle);
            }
            else if (this.selectedRadioButtonText.equals("Rechtteck"))
            {
                drawRectangle(lastPositionX, lastPositionY, Color.BLACK, 2);
                this.rechtecke.add(this.rectangle);
            }

            this.updateLabel();
        });

        grafikPane.setOnMouseDragged(e ->
        {
            double lastPositionX = e.getX();
            double lastPositionY = e.getY();
            if (this.selectedRadioButtonText.equals("Linie"))
            {
                this.drawLine(lastPositionX, lastPositionY, Color.GRAY, 0.5);
            }
            else if (this.selectedRadioButtonText.equals("Kreis"))
            {
                drawCircle(lastPositionX, lastPositionY, Color.GRAY, 0.5);
            }
            else if (this.selectedRadioButtonText.equals("Rechtteck"))
            {
                drawRectangle(lastPositionX, lastPositionY, Color.RED, 0.5);
            }

        });

        // Handlers fuer RadioButtons
        toggleGroup.selectedToggleProperty().addListener((o, a, b) ->
        {
            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            this.selectedRadioButtonText = selectedRadioButton.getText();

        });

        return root;
    }

    private void drawCircle(double endX, double endY, Color color, double strokeWidth)
    {
        // Pythagores
        double a = Math.pow(endX - this.startX, 2) + Math.pow(endY - this.startY, 2);
        double radius = Math.sqrt(a);
        if (this.circle != null)
        {
            this.grafikPane.getChildren().remove(this.circle);
        }

        circle = new Circle(this.startX, this.startY, radius);
        circle.setStroke(color);
        circle.setStrokeWidth(strokeWidth);
        circle.setFill(null); // Nicht ausfuellen
        this.grafikPane.getChildren().add(circle);
    }

    private void drawRectangle(double endX, double endY, Color color, double strokeWidth)
    {
        double width = endX - this.startX;
        double height = endY - this.startY;

        if (width < 0)
        {
            // this.startX = -startX;
        }
        if (height < 0)
        {
            // this.startY = -startY;
        }
        Rectangle newRectangle = new Rectangle(this.startX, this.startY, Math.abs(width), Math.abs(height));

        if (strokeWidth == 0.5)
        {

            newRectangle.setStroke(color);
            newRectangle.setStrokeWidth(strokeWidth);
            newRectangle.setFill(null); // Nicht ausfuellen

            this.grafikPane.getChildren().add(newRectangle);

            if (this.rectangle != null)
            {
                this.grafikPane.getChildren().remove(this.rectangle);

            }

        }
        else
        {
            this.rectangle = newRectangle;
            newRectangle.setStroke(Color.BLACK);
            newRectangle.setStrokeWidth(2.0);
            newRectangle.setFill(null); // Nicht ausfuellen
            System.out.println(this.rectangle);
        }

        this.rectangle = newRectangle;

    }

    private void updateLabel()
    {
        int lineAnzahl = 12;
        int kreiseAnzahl = this.kreise.size();
        int rechtteckAnzahl = this.rechtecke.size();
        String textLabel = "Linien:" + lineAnzahl + ", " + "Kreise:" + kreiseAnzahl + ", " + "Rechttecke:" + rechtteckAnzahl;
        this.labelProtocol.setText(textLabel);
        for (Rectangle newRectangle : this.rechtecke)
        {

            newRectangle.setStroke(Color.BLACK);
            newRectangle.setStrokeWidth(2.0);
            newRectangle.setFill(null); // Nicht ausfuellen

        }
    }

    private void drawLine(double endX, double endY, Color color, double strokeWidth)
    {
        // Line erzeugen
        this.line = new Line(this.startX, this.startY, endX, endY);
        // Farbe der Linie
        this.line.setStroke(color);
        // Duennere/dickere Linie
        this.line.setStrokeWidth(strokeWidth);

        // Linie zeichen lassen
        this.grafikPane.getChildren().add(line);

        // Damit andere Punkt fest bleibt (Gummibandeffekt)
        this.startX = endX;
        this.startY = endY;

        // Append line
        lineList.add(this.line);
        if (strokeWidth == 2)
        {
            // Update all Lines
            for (Line li : lineList)
            {
                li.setStroke(color);
                // Duennere/dickere Linie
                li.setStrokeWidth(strokeWidth);
            }

        }

    }

}
