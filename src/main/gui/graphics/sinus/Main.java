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
        SinusModel sinusModel = new SinusModel(0.57, 2.09, 0.0, 50.0);
        SinusPresenter sinusPresenter = new SinusPresenter();

        SinusView sinusView = new SinusView(sinusPresenter);
        sinusPresenter.setModelAndView(sinusView, sinusModel);

        primaryStage.setScene(sinusView.getUi());
        primaryStage.setTitle("Sinus");
        primaryStage.show();

    }

}
