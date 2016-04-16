package firecamp;

import config.Tools;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import models.Project;
import models.User;
import services.ProjectService;
import services.UserService;

public class LoginController implements Initializable {

    @FXML
    private TextField userTextField;
    @FXML
    private PasswordField passPasswordField;

    private User _loggedUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    protected void handleLoginButtonAction(ActionEvent event) {
        String username = userTextField.getText();
        String pass = Tools.MD5(passPasswordField.getText());
        boolean isAuthenticated = authentication(username, pass);
        if (isAuthenticated) {
            showHomeStage(_loggedUser);
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Credenciales no váildas");
            alert.setContentText("El usuario y clave proporcionados no son válidos");
            alert.showAndWait();
        }
    }

    private boolean authentication(String username, String pass) {
        // TODO for testing
//        _loggedUser = testUser();
//        return true;

        try {
            List<User> users = UserService.getInstance().Select(String.format("username = '%s' AND password = '%s'", username, pass));
            if (users != null && users.size() == 1 && users.get(0).isAdmin()) {
                _loggedUser = users.get(0);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se pudo iniciar la aplicación");
            alert.setContentText("Hubo un error al intentar iniciar FireCamp");
            alert.showAndWait();
            System.out.println("Error " + e.getMessage());
            return false;
        }

    }

    public void showHomeStage(User user) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));

        try {
            Scene scene = new Scene((Pane) loader.load());
            HomeController controller = loader.<HomeController>getController();
            controller.initData(user);
            FireCamp.getMainStage().hide();
            FireCamp.getMainStage().setResizable(true);
            FireCamp.getMainStage().setMaximized(true);
            FireCamp.getMainStage().setScene(scene);
            FireCamp.getMainStage().setTitle("FireCamp");
            FireCamp.getMainStage().show();
        } catch (Exception e) {
        }
    }

    private void TestingConnection() {
        try {
            User user = testUser();
            Project project = new Project();
            project.setName("Example");
            project.setDescription("Example Project");
            project.setClient(user);
            project.setManager(user);
//            UserService.getInstance().InsertOrUpdate(user);
//            List<User> users = UserService.getInstance().Select(null);
            ProjectService.getInstance().InsertOrUpdate(project);
            List<Project> projects = ProjectService.getInstance().Select(null);
            System.out.println("Success");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private User testUser() {
        User user = new User();
        user.setId(2);
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
