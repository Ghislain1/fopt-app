package fopt.pp2020.lin.tag2;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.List;

public class Aufgabe2 extends Application {

    private static final double RADIUS = 20;
    private Pane graphicsPane;
    private Circle circle;
    private Line line;
    private Rectangle rectangle;
    private ToggleGroup group;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;


    public Aufgabe2() {
        group = new ToggleGroup();
        rb1 = new RadioButton("Linie");
        rb2 = new RadioButton("Kreis");
        rb3 = new RadioButton("Rechteck");
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        graphicsPane = new Pane();

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                // Has selection.
                if (group.getSelectedToggle() != null) {
                    RadioButton button = (RadioButton) group.getSelectedToggle();
                    if("Linie".equals(button.getText())){

                        graphicsPane.setOnMousePressed
                            (
                                    e -> mousePressedDrawLine(e.getX(), e.getY())
                            );

                        graphicsPane.setOnMouseDragged
                            (
                                     e -> mouseDraggedDrawLine(e.getX(), e.getY())
                            );
                        graphicsPane.setOnMouseReleased
                            (
                                    e -> mouseReleased()
                            );

                    };
                    if("Kreis".equals(button.getText())){

                        graphicsPane.setOnMousePressed
                                (
                                        e -> mousePressedDrawCircle(e.getX(), e.getY())
                                );

                        graphicsPane.setOnMouseDragged
                                (
                                        e -> mouseDraggedDrawCircle(e.getX(), e.getY())
                                );
                        graphicsPane.setOnMouseReleased
                                (
                                        e -> mouseReleased()
                                );

                    };
                }
            }
        });

//            graphicsPane.setOnMousePressed
//                    (
//                            e -> mousePressed(e.getX(), e.getY())
//                    );
//
//            graphicsPane.setOnMouseDragged
//                    (
//                             e -> mouseDragged(e.getX(), e.getY())
//                    );
//            graphicsPane.setOnMouseReleased
//                    (
//                            e -> mouseReleased()
//                    );

        primaryStage.setTitle("Rote Kreise");
        HBox hBox = new HBox(rb1, rb2, rb3);
        graphicsPane.getChildren().add(hBox);
        primaryStage.setScene(new Scene(graphicsPane, 350, 120));
        primaryStage.show();
    }

    private void mousePressedDrawLine(Double x, Double y) {
        line = new Line(x,y,x,y);
        line.setFill(Color.TRANSPARENT);
        line.setStroke(Color.RED);
        graphicsPane.getChildren().add(line);
    }


    private void mouseDraggedDrawLine(Double x, Double y) {
        line.setEndX(x);
        line.setEndY(y);
    }

    private void mousePressedDrawCircle(Double x, Double y) {
        circle = new Circle();
        circle.setCenterX(x);
        circle.setCenterY(y);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.RED);
        graphicsPane.getChildren().add(circle);
    }


    private void mouseDraggedDrawCircle(Double x, Double y) {
        Double pi = 3.1415926;
        Double radius = Math.sqrt((x-circle.getCenterX())*(x-circle.getCenterX()) + (y-circle.getCenterY())*(y-circle.getCenterY()));
        circle.setRadius(radius);
    }


    private void mousePressed(Double x, Double y) {
//        c= new Circle();

        line.setStartX(x);
        line.setStartY(y);
        line.setFill(Color.TRANSPARENT);
        line.setStroke(Color.RED);
        graphicsPane.getChildren().add(line);
    }

    private void mouseDragged(Double x, Double y) {
        line.setEndX(x);
        line.setEndY(y);
    }

    private void mouseReleased() {
        if(null!=line){
            line.setFill(Color.BLACK);
        }
        if(null!=circle){
            circle.setFill(Color.BLACK);
        }
        if(null!=rectangle){
            rectangle.setFill(Color.BLACK);
        }
    }


}
