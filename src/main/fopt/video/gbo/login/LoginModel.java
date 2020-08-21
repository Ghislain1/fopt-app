package fopt.video.gbo.login;

import java.util.HashMap;

public class LoginModel
{
    private HashMap<String, String> map;

    public LoginModel()
    {

        this.map = new HashMap<>();
        this.map.put("Ghislain", "ghislain");
        this.map.put("Lin", "lin");
        this.map.put("Dansy", "cool2020");
    }

    public boolean isOkay(String name, String password)
    {
        return password.equals(this.map.get(name));
    }

}
