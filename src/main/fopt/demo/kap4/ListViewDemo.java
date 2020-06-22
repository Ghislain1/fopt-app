package fopt.demo.kap4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ListViewDemo extends Application
{

    public static void main(String[] args)
    {
        launch(args);

    }

    @Override
    public void start(Stage primStage) throws Exception
    {
        HBox hbox = new HBox();

        // Instanzoeren Listview Objekt
        ListView<String> listview = new ListView<String>();

        ObservableList<String> alphabet = FXCollections.observableArrayList("A", "B", "C");
        listview.setItems(alphabet);

        // Listview anordnen
        hbox.getChildren().add(listview);

        Scene scene = new Scene(hbox, 300, 100);
        primStage.setTitle("Listview- Demo");
        primStage.setScene(scene);
        primStage.show();

    }

}
