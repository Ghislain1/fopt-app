package fopt.demo.kap4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
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
        ListView<Person> listview = new ListView<Person>();

        ObservableList<Person> people = FXCollections.observableArrayList(new Person("1", "Frank"), new Person("2", "Daniel"));

        listview.setItems(people);

        // Listview anordnen
        hbox.getChildren().add(listview);

        // Adapter
        listview.setCellFactory(param -> new ListCell<Person>()
        {
            @Override
            protected void updateItem(Person item, boolean empty)
            {
                super.updateItem(item, empty);

                if (empty || item == null || item.getName() == null)
                {
                    setText(null);
                }
                else
                {
                    // Setup den Text, der anzuzeigen ist.
                    setText(item.getName());
                }
            }
        });

        Scene scene = new Scene(hbox, 300, 100);
        primStage.setTitle("Listview- Demo");
        primStage.setScene(scene);
        primStage.show();

    }

}
