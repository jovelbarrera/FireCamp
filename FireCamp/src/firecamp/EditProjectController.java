package firecamp;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.Project;
import models.User;
import services.ProjectService;

public class EditProjectController implements Initializable {

    private Project _project;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void initData(Project project) {
        _project = project;
        setControlsData();
    }

    private void setControlsData() {
        projectNameLabel.setText(String.valueOf(_project.getId()));
        clientNameLabel.setText(_project.getClient().getFirstName() + " " + _project.getClient().getLastName());
        clienteEmailLabel.setText(_project.getClient().getEmail());
        clienteEmailLabel.setText(_project.getClient().getEmail());
        clientOrganizationLabel.setText(_project.getClient().getOrganization());
        projectDescription.setText(_project.getDescription());
    }

    private void getControlsData() {
        LocalDate localDate = startAtPicker.getValue();
        Date startedAt = java.sql.Date.valueOf(localDate);
        _project.setStaredAt(startedAt);

        localDate = deadlineAtPicker.getValue();
        Date deadlineAt = java.sql.Date.valueOf(localDate);
        _project.setDeadlineAt(deadlineAt);
        // TODO testing
        User manager = new User();
        manager.setId(2);
        _project.setManager(manager);
    }

    private boolean updateProject() {
        boolean success = false;
        getControlsData();
        try {
            success = ProjectService.getInstance().InsertOrUpdate(_project);
        } catch (Exception e) {
            success = false;
        }
        return success;
    }

    @FXML
    protected void handleAcceptButtonAction(ActionEvent event) {
        if (updateProject()) {
            Stage stage = (Stage) acceptButton.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No actualizado");
            alert.setContentText("Este proyecto no pudo ser actualizado en este momento.");
            alert.showAndWait();
        }
    }
}
