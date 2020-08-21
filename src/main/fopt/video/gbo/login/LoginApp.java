package fopt.video.gbo.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginApp extends Application
{
    public static void main(String[] args)
    {
        launch(args);

    }

    @Override
    public void start(Stage pStage)
    {
        LoginPresenter p = new LoginPresenter();

        LoginView v = new LoginView(p);
        LoginModel m = new LoginModel();

        // p.setModel(m);
        p.setView(v);

        Pane root = v.getUI();
        pStage.setScene(new Scene(root, 500, 200));
        pStage.setTitle("Login");
        pStage.show();
    }
}
