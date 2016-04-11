package firecamp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import models.User;

public class HomeController implements Initializable
{

    private User _currentUser;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }

    public void initData(User user)
    {
        _currentUser = user;
    }
}
