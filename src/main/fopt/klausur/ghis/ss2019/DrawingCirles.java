package fopt.klausur.ghis.ss2019;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DrawingCirles extends Application
{
    public static double RADIUS = 20;

    private Circle c;

    private Pane graphicsPane;

    public static void main(String[] args)
    {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage)
    {
        this.graphicsPane = new Pane();
        this.graphicsPane.setOnMousePressed(e -> mousePressed(e.getX(), e.getY()));
        this.graphicsPane.setOnMouseDragged(e -> mouseDragged(e.getX(), e.getY()));
        this.graphicsPane.setOnMouseReleased(e -> mouseReleased());

        primaryStage.setTitle("Rote Kreise");
        primaryStage.setScene(new Scene(this.graphicsPane, 344, 120));
        primaryStage.show();

    }

    private void mouseDragged(double x, double y)
    {
        this.c.setCenterX(x);
        this.c.setCenterY(y);
    }

    private void mouseReleased()
    {
        this.c.setFill(Color.RED);
    }

    private void mousePressed(double x, double y)
    {
        this.c = new Circle(x, y, RADIUS);
        this.c.setFill(null);
        this.c.setStroke(Color.RED); // Farbe der Begrenzunglinie
        this.graphicsPane.getChildren().add(this.c);
    }
}
