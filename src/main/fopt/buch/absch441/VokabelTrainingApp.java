package fopt.buch.absch441;

import javafx.application.Application;
import javafx.stage.Stage;

public class VokabelTrainingApp extends Application
{

    public static void main(String[] args)
    {
        launch(args);

    }

    @Override
    public void start(Stage stage)
    {

        Model model = new Model();
        Presenter presenter = new Presenter(model);
        View view = new View(presenter);
        view.init(stage);

    }

}
