package firecamp;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import models.User;
import services.UserService;

public class LoginController implements Initializable
{

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        TestingConnection();
    }

    @FXML
    protected void handleLoginButtonAction(ActionEvent event)
    {
        try
        {
            showHomeStage(testUser());
        }
        catch (Exception e)
        {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void showHomeStage(User user)
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));

        try
        {
            Scene scene = new Scene((Pane) loader.load());            
            HomeController controller = loader.<HomeController>getController();
            controller.initData(user);
            FireCamp.getMainStage().hide();
            FireCamp.getMainStage().setResizable(true);
            FireCamp.getMainStage().setMaximized(true);
            FireCamp.getMainStage().setScene(scene);
            FireCamp.getMainStage().show();
        }
        catch (Exception e)
        {
        }
    }

    private void TestingConnection()
    {
        try
        {
            User user = testUser();
            UserService.getInstance().InsertOrUpdate(user);
            List<User> users = UserService.getInstance().Select(null);
            System.out.println("Success");
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private User testUser()
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
        return user;
    }
}
