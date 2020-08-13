package fopt.klausur.lin.aufgabe6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Aufgabe6 extends Application {

    private static final double RADIUS = 20;
    private Pane graphicsPane;
    private Circle c;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

            graphicsPane = new Pane();
            graphicsPane.setOnMousePressed
                    (
//                            e -> mousePressed(e.getX(), e.getY())
                            e -> System.out.println("mouse pressed")
                    );

            graphicsPane.setOnMouseDragged
                    (
//                            e -> mouseDragged(e.getX(), e.getY())
                            e -> System.out.println("mouse dragged")
                    );
            graphicsPane.setOnMouseReleased
                    (
//                            e -> mouseReleased()
                            e -> System.out.println("mouse released")
                    );
            primaryStage.setTitle("Rote Kreise");
            primaryStage.setScene(new Scene(graphicsPane,350,120));
            primaryStage.show();
    }
}
