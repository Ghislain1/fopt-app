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
        View view = new View();
        Model model = new Model();

        view.setPresenter(new Presenter(view, model));
        view.init(stage);

    }

}
