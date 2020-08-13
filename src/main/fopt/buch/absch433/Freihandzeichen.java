package fopt.buch.absch433;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Freihandzeichen extends Application
{
    private Pane pane;

    double x, y;

    public static void main(String[] args)
    {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage)
    {
        BorderPane root = this.getUI();

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Freihandzeichen");
        primaryStage.show();

    }

    private BorderPane getUI()
    {

        // Elements
        Button button = new Button("Clear");
        Label label = new Label("Irgendein wichtiger Text");

        // Containers
        BorderPane borderPane = new BorderPane();

        HBox hbox = new HBox(20);
        pane = new Pane();

        // usage
        hbox.getChildren().addAll(button, label);
        borderPane.setBottom(hbox);
        borderPane.setCenter(pane);
        borderPane.setPadding(new Insets(19));

        // Handler
        button.setOnAction(e ->
        {
            this.pane.getChildren().clear();
        });
        pane.setOnMousePressed(e ->
        {
            // Sprung effekt zu vermeinden
            this.x = e.getX();
            this.y = e.getY();
            this.mouseDragged(e.getX(), e.getY());

        });

        pane.setOnMouseDragged(e ->
        {
            this.mouseDragged(e.getX(), e.getY());
            this.x = e.getX();
            this.y = e.getY();
        });

        return borderPane;
    }

    private void mouseDragged(double newX, double newY)
    {
        Line line = new Line(x, y, newX, newY);
        pane.getChildren().add(line);
        this.x = newX;
        this.y = newY;

    }

}
