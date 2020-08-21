package fopt.video.gbo.login;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class LoginView
{
    Pane pane;

    private TextField usernameTextField;

    private TextField passwordTextField;

    private LoginPresenter loginPresenter;

    public LoginView(LoginPresenter loginPresenter)
    {
        this.loginPresenter = loginPresenter;
        this.intView();
    }

    public void showOkayMsg()
    {

    }

    private void intView()
    {
        this.pane = new Pane();
        Label labelName = new Label("Username");
        Label labelPassword = new Label("Password");
        passwordTextField = new TextField();
        usernameTextField = new TextField();

        VBox vbox1 = new VBox();
        HBox hbox1 = new HBox();

        this.pane.getChildren().add(labelPassword);

    }

    public void resetInput()
    {
        // TODO Auto-generated method stub

    }

    public void showErrorMsg()
    {
        // TODO Auto-generated method stub

    }

    public Pane getUI()
    {

        return this.pane;
    }

}
