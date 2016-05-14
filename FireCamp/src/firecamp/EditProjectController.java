package firecamp;

import firecamp.cells.TextCell;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.Project;
import models.User;
import services.ProjectService;
import services.UserService;

public class EditProjectController implements Initializable {

    private Project _project;
    private User _currentUser;
    @FXML
    private Label projectNameLabel;
    @FXML
    private Label clientNameLabel;
    @FXML
    private Label clienteEmailLabel;
    @FXML
    private Label clientOrganizationLabel;
    @FXML
    private Label projectDescription;
    @FXML
    private DatePicker startAtPicker;
    @FXML
    private DatePicker deadlineAtPicker;
    @FXML
    private Button acceptButton;
    @FXML
    private ComboBox<TextCell> projectManagerComboBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void initData(User currentUser, Project project) {
        _currentUser = currentUser;
        _project = project;
        setControlsData();
        getInternalUsers();
    }

    private void setControlsData() {
        projectNameLabel.setText(_project.getName());
        clientNameLabel.setText(_project.getClient().getFirstName() + " " + _project.getClient().getLastName());
        clienteEmailLabel.setText(_project.getClient().getEmail());
        clienteEmailLabel.setText(_project.getClient().getEmail());
        clientOrganizationLabel.setText(_project.getClient().getOrganization());
        projectDescription.setText(_project.getDescription());
    }

    private void getInternalUsers() {
        try {
            List<User> users = UserService.getInstance().Select("isInternal = true");
            List<TextCell> list = new ArrayList<>();
            users.stream().forEach((user) -> {
                list.add(new TextCell<User>(user, user.getFirstName() + " " + user.getLastName()));
            });
            ObservableList<TextCell> observableList = FXCollections.observableList(list);
            projectManagerComboBox.setItems(observableList);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void alertWarning(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertencia");
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void alertError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void getControlsData() {
        TextCell<User> selectedItem = projectManagerComboBox.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            User projectManager = (User) projectManagerComboBox.getSelectionModel().getSelectedItem().getModel();
            _project.setManager(projectManager);
        }

        LocalDate localDate = startAtPicker.getValue();
        if (localDate != null) {
            Date startedAt = java.sql.Date.valueOf(localDate);
            _project.setStaredAt(startedAt);
        } else {
            _project.setStaredAt(null);
        }

        localDate = deadlineAtPicker.getValue();
        if (localDate != null) {
            Date deadlineAt = java.sql.Date.valueOf(localDate);
            _project.setDeadlineAt(deadlineAt);
        } else {
            _project.setDeadlineAt(null);
        }

    }

    private boolean validateData() {
        getControlsData();
        if (_project.getDeadlineAt() == null || _project.getStaredAt() == null) {
            alertWarning("Información requerida", "Escoja una fecha de inicio y una fecha de entrega");
            return false;
        } else if (_project.getDeadlineAt().before(_project.getStaredAt())) {
            alertWarning("Información no válida", "La fecha de inicio debe ser antes de la fecha de entrega");
            return false;
        } else if (_project.getManager() == null || _project.getManager().getId() == 0) {
            alertWarning("Información requerida", "Escoja un project manager");
            return false;
        } else {
            return true;
        }

    }

    @FXML
    protected void handleAcceptButtonAction(ActionEvent event) {
        if (validateData()) {
            try {
                _project.setAccepted(true);
                _project.setIsActive(true);
                boolean success = ProjectService.getInstance().InsertOrUpdate(_project);
                if (success) {
                    HomeController.getInstance().initData(_currentUser);
                    Stage stage = (Stage) acceptButton.getScene().getWindow();
                    stage.close();
                } else {
                    alertError("No se pudo guardar", "No se pudo actualizar la base de datos");
                }
            } catch (Exception e) {
                alertError("No se pudo guardar", "No se pudo actualizar la base de datos");
            }
        }
    }

    @FXML
    protected void handleDenyButtonAction(ActionEvent event) {
        try {
            _project.setAccepted(false);
            boolean success = ProjectService.getInstance().InsertOrUpdate(_project);
            if (success) {
                HomeController.getInstance().initData(_currentUser);
                Stage stage = (Stage) acceptButton.getScene().getWindow();
                stage.close();
            } else {
                alertError("No se pudo guardar", "No se pudo actualizar la base de datos");
            }
        } catch (Exception e) {
            alertError("No se pudo guardar", "No se pudo actualizar la base de datos");
        }
    }
}
