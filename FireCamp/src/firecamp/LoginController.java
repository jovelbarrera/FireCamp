package firecamp;

import java.net.URL;
import java.util.Dictionary;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.User;
import services.UserService;

public class LoginController implements Initializable
{

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        TetingConnection();
    }

    private void TetingConnection()
    {
        try
        {
            User user = new User();
            user.setUsername("jovel@mail.com");
            user.setEmail("jovel@mail.com");
            user.setPassword("jovel");
            user.setPicture("https://media.licdn.com/mpr/mpr/shrinknp_400_400/AAEAAQAAAAAAAALoAAAAJGExNGVhZGE2LTdjNTktNGQyNi04YTA3LTg2ZjRmYzA5MGQ3Nw.jpg");
            user.setFirstName("Roberto Ernesto");
            user.setLastName("Jovel Barrera");
            user.setOrganization("FireCamp");
            user.setIsActive(true);
            user.setPosition("Project Manager");
            UserService.getInstance().InsertOrUpdate(user);
            List<User> users = UserService.getInstance().Select(null);
            System.out.println("Success");
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
