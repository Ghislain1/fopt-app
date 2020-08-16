package fopt.pp2020.tag2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
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

    private List<Line> linien;

    private List<Circle> kreise;

    private List<Rectangle> rechtecke;

    private HashMap<Line, List<Line>> lineMap;

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
        HBox hbox1 = new HBox(); // Container NUR fuer RadionsButtons
        HBox hbox2 = new HBox(); // Container NUR fuer Bottom Elements
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton lineRadioButton = new RadioButton("Linie");
        RadioButton kreisRadioButton = new RadioButton("Kreis");
        RadioButton rechtteckRadioButton = new RadioButton("Rechtteck");

        Button bntProtokoll = new Button("Protokoll");
        Button bntLoeschen = new Button("Loeschen");
        String txtlabel = "Linien:" + 0 + ", " + "Kreise:" + 0 + ", " + "Rechttecke:" + 0;
        this.labelProtocol = new Label(txtlabel);

        this.textArea = new TextArea("  "); // For seconde window

        // RadioButtons zusammenfassen
        toggleGroup.getToggles().addAll(lineRadioButton, kreisRadioButton, rechtteckRadioButton);

        // Properties setzen
        lineRadioButton.setSelected(true);
        this.selectedRadioButtonText = "Linie";
        this.lineList = new ArrayList<>();
        this.linien = new ArrayList<>();
        this.kreise = new ArrayList<>();
        this.rechtecke = new ArrayList<>();
        this.lineMap = new HashMap<>();
        // Bereich hineingehen vermeidem
        clipChildren(this.grafikPane, this.grafikPane.getWidth(), this.grafikPane.getHeight());

        // Anordnen
        lineRadioButton.setPadding(new Insets(1.5));
        kreisRadioButton.setPadding(new Insets(1.5));
        rechtteckRadioButton.setPadding(new Insets(1.5));
        bntProtokoll.setPadding(new Insets(1.5));
        bntLoeschen.setPadding(new Insets(1.5));
        hbox2.setSpacing(10);
        hbox1.getChildren().addAll(lineRadioButton, kreisRadioButton, rechtteckRadioButton, bntLoeschen);
        root.setTop(hbox1);
        root.setCenter(this.grafikPane);
        hbox2.getChildren().addAll(this.labelProtocol, bntProtokoll);

        root.setBottom(hbox2);

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

            }
            else if (this.selectedRadioButtonText.equals("Rechtteck"))
            {
                drawRectangle(lastPositionX, lastPositionY, Color.BLACK, 2);

            }

            this.update();
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
                drawRectangle(lastPositionX, lastPositionY, Color.GRAY, 0.5);
            }

        });

        // TODO@GHze: Nochmal lesen vor Klausur
        // Handlers fuer RadioButtons
        toggleGroup.selectedToggleProperty().addListener((o, a, b) ->
        {
            RadioButton selectedRadioButton = (RadioButton) o.getValue();
            this.selectedRadioButtonText = selectedRadioButton.getText();

        });
        bntProtokoll.setOnAction(e ->
        {
            Stage secondaryStage = new Stage();

            // Fenster anzeigen
            secondaryStage.setScene(new Scene(textArea, 1000, 200));
            secondaryStage.setTitle("Protokoll");
            secondaryStage.show();

        });
        bntLoeschen.setOnAction(e ->
        {
            this.grafikPane.getChildren().clear();
            this.line = null;
            this.kreise.clear();
            this.lineMap.keySet().clear();
            this.rechtecke.clear();

            ;
            this.labelProtocol.setText("Linien:" + 0 + ", " + "Kreise:" + 0 + ", " + "Rechttecke:" + 0);

        });

        return root;
    }

    private TextArea textArea;

    private void drawCircle(double endX, double endY, Color color, double strokeWidth)
    {
        // Pythagores
        double a = Math.pow(endX - this.startX, 2) + Math.pow(endY - this.startY, 2);
        double radius = Math.sqrt(a);

        Circle newCircle = new Circle(this.startX, this.startY, radius);
        newCircle.setStroke(color);
        newCircle.setStrokeWidth(strokeWidth);
        newCircle.setFill(null); // Nicht ausfuellen
        this.grafikPane.getChildren().add(newCircle);

        // Condition: Brauch Verbesserung
        if (strokeWidth == 0.5 && color.equals(Color.GRAY))
        {
            if (this.circle != null)
            {
                this.grafikPane.getChildren().remove(circle);
            }
            // Letzte Merken!!
            this.circle = newCircle;
        }
        else
        {
            this.kreise.add(newCircle);
        }

    }

    private void drawRectangle(double endX, double endY, Color color, double strokeWidth)
    {
        double width = endX - this.startX;
        double height = endY - this.startY;

        // Zum Fragen!!!
        if (width < 0)
        {
            // this.startX = -startX;
        }
        if (height < 0)
        {
            // this.startY = -startY;
        }
        Rectangle newRectangle = new Rectangle(this.startX, this.startY, Math.abs(width), Math.abs(height));

        newRectangle.setStroke(color);
        newRectangle.setStrokeWidth(strokeWidth);
        newRectangle.setFill(null); // Nicht ausfuellen
        this.grafikPane.getChildren().add(newRectangle);
        if (strokeWidth == 0.5 && color.equals(Color.GRAY))
        {
            if (this.rectangle != null)
            {
                this.grafikPane.getChildren().remove(this.rectangle);

            }
            this.rectangle = newRectangle;
        }
        else
        {
            this.rechtecke.add(newRectangle);
        }

    }

    private void update()
    {
        int lineAnzahl = this.lineMap.keySet().size();
        int kreiseAnzahl = this.kreise.size();
        int rechtteckAnzahl = this.rechtecke.size();
        String textLabel = "Linien:" + lineAnzahl + ", " + "Kreise:" + kreiseAnzahl + ", " + "Rechttecke:" + rechtteckAnzahl;
        this.labelProtocol.setText(textLabel);
        // this.grafikPane.requestFocus();

        if (this.selectedRadioButtonText.equals("Linie"))
        {
            // TODO@GHze: Verbesserung
            this.textArea.appendText(this.lineMap.keySet().toArray()[0].toString() + "\n");
        }
        else if (this.selectedRadioButtonText.equals("Kreis"))
        {
            // TODO@GHze: Nochmal lesen vor Klausur
            this.textArea.appendText(this.kreise.get(kreiseAnzahl - 1).toString() + "\n");
        }
        else if (this.selectedRadioButtonText.equals("Rechtteck"))
        {
            if (rechtecke == null)
            {
                return;
            }
            // TODO@GHze: Nochmal lesen vor Klausur--> Method appendText
            this.textArea.appendText(this.rechtecke.get(rechtteckAnzahl - 1).toString() + "\n");
        }

    }

    // TODO@GhZe- Nochmal vor Klausur--> Wie man Linie Bereich hineingehen
    // vermeinden
    static void clipChildren(Region region, double width, double height)
    {

        final Rectangle outputClip = new Rectangle();
        outputClip.setArcWidth(width);
        outputClip.setArcHeight(height);
        region.setClip(outputClip);

        // TODO@GhZe- Nochmal vor Klausur
        region.layoutBoundsProperty().addListener((ov, oldValue, newValue) ->
        {
            outputClip.setWidth(newValue.getWidth());
            outputClip.setHeight(newValue.getHeight());
        });
    }

    private void drawLine(double endX, double endY, Color color, double strokeWidth)
    {
        // Line erzeugen
        this.line = new Line(this.startX, this.startY, endX, endY);
        // Farbe der Linie
        this.line.setStroke(color);
        // Duennere/dickere Linie
        this.line.setStrokeWidth(strokeWidth);

        // Aliasing
        this.line.setSmooth(true);
        // Linie zeichen lassen
        this.grafikPane.getChildren().add(line);

        // Damit andere Punkt fest bleibt (Gummibandeffekt)
        this.startX = endX;
        this.startY = endY;

        // Append line
        lineList.add(this.line);

        // NEDD: Verbesserung
        if (strokeWidth == 2 && color.equals(Color.BLACK))
        {
            // Update all Lines
            for (Line li : lineList)
            {
                li.setStroke(color);
                // Duennere/dickere Linie
                li.setStrokeWidth(strokeWidth);
            }
            this.lineMap.put(this.line, lineList);
            this.lineList.clear();

        }

    }

}
