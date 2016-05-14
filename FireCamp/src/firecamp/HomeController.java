package firecamp;

import firecamp.cells.ActiveProjectCell;
import firecamp.cells.PendingProjectCell;
import firecamp.cells.UsersCell;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import models.Privilege;
import models.Project;
import models.User;
import services.PrivilegeService;
import services.ProjectService;
import services.UserService;

public class HomeController implements Initializable {

    private static HomeController _instance;

    public static HomeController getInstance() {
        return _instance;
    }
    @FXML
    private ListView<ActiveProjectCell> activeProjectsListView;
    @FXML
    private ListView<PendingProjectCell> pendingProjectsListView;
    @FXML
    private ListView<UsersCell> usersListView;

    private User _currentUser;

    public HomeController() {
        _instance = this;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void initData(User user) {

        _currentUser = user;
        UpdateStage();
    }

    public void UpdateStage() {
        LoadActiveProjects();
        LoadPendingProjects();
        LoadUsers();
    }

    public void LoadActiveProjects() {
        try {
            List<Project> projects = ProjectService.getInstance().Select("isActive = true ORDER BY deadlineAt ASC");
            List<ActiveProjectCell> list = new ArrayList<>();
            projects.stream().forEach((project) -> {
                list.add(new ActiveProjectCell(project));
            });
            ObservableList<ActiveProjectCell> observableList = FXCollections.observableList(list);
            activeProjectsListView.setItems(observableList);
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Falló carga de datos");
            alert.setContentText("No se pudieron cargar los proyectos activos");
            alert.showAndWait();
        }
    }

    public void LoadPendingProjects() {
        try {
            List<Project> projects = ProjectService.getInstance().Select("accepted IS NULL ORDER BY deadlineAt ASC");
            List<PendingProjectCell> list = new ArrayList<>();
            projects.stream().forEach((project) -> {
                list.add(new PendingProjectCell(_currentUser, project));
            });
            ObservableList<PendingProjectCell> observableList = FXCollections.observableList(list);
            pendingProjectsListView.setItems(observableList);
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Falló carga de datos");
            alert.setContentText("No se pudieron cargar los proyectos solicitados");
            alert.showAndWait();
        }
    }

    public void LoadUsers() {
        try {
            List<User> users = UserService.getInstance().Select(null);
            List<UsersCell> list = new ArrayList<>();
            users.stream().forEach((user) -> {
                if (_currentUser.getId() != user.getId()) {
                    String where = String.format("userId = %d", user.getId());
                    try {
                        List<Privilege> privileges = PrivilegeService.getInstance().Select(where);
                        if (privileges.isEmpty()) {
                            list.add(new UsersCell(_currentUser, user, new Privilege()));
                        } else {
                            list.add(new UsersCell(_currentUser, user, privileges.get(0)));
                        }
                    } catch (Exception ex ) {
                        list.add(new UsersCell(_currentUser, user, new Privilege()));
                    }
                }
            });
            ObservableList<UsersCell> observableList = FXCollections.observableList(list);
            usersListView.setItems(observableList);
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Falló carga de datos");
            alert.setContentText("No se pudieron cargar los datos de usuarios");
            alert.showAndWait();
        }
    }

    @FXML
    protected void updateMenuBarAction(ActionEvent event) {
        UpdateStage();
    }

    @FXML
    protected void closeMenuBarAction(ActionEvent event) {
        Platform.exit();
    }

}
