package fopt.buch.absch431;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContainerDemo extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Pane root = new VBox();
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 400, 400);
        scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        // Interaktionselemente
        Label label = new Label("12");
        Button bt1 = new Button("Erhoehen");
        bt1.setMaxHeight(500);

        Button bt2 = new Button("Zurecktsetzen");

        // Anordnet
        root.getChildren().add(label);
        root.getChildren().add(bt1);
        root.getChildren().add(bt2);

        VBox.setVgrow(bt1, Priority.ALWAYS);

        stage.setScene(scene);
        stage.setTitle("Container-Type");
        stage.show();
    }

}
