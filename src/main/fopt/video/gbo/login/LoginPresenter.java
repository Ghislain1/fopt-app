package fopt.video.gbo.login;

public class LoginPresenter
{
    private LoginModel loginModel;

    private LoginView loginView;

    public void setModel(LoginModel loginModel)
    {
        if (loginModel == null)
        {
            throw new IllegalArgumentException(" Model  shoulb not be null ");
        }
        this.loginModel = loginModel;
    }

    public void setView(LoginView loginView)
    {
        if (loginView == null)
        {
            throw new IllegalArgumentException(" View  shoulb not be null ");
        }
        this.loginView = loginView;
    }

    public void login(String name, String password)
    {

        if (name == "" || password == "")
        {
            this.loginView.showErrorMsg();
        }
        boolean isOk = this.loginModel.isOkay(name, password);
        if (isOk)
        {
            loginView.showOkayMsg();
            loginView.resetInput();
        }

    }
}
