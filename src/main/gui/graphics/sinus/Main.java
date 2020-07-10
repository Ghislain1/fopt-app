package gui.graphics.sinus;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{

    public static void main(String[] args)
    {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage)
    {
        // JavaFx Elements
        SinusModel sinusModel = new SinusModel();

        SinusView sinusView = new SinusView();

        SinusPresenter sinusPresenter = new SinusPresenter(sinusView, sinusModel);
        sinusView.setPresenter(sinusPresenter);

        primaryStage.setScene(sinusView.getUi());
        primaryStage.setTitle("Sinus");
        primaryStage.show();

    }

}
