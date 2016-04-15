package firecamp.cells;

import firecamp.EditProjectController;
import firecamp.FireCamp;
import java.text.SimpleDateFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Project;

public class PendingProjectCell extends HBox {

    private Project _project;
    VBox vBox = new VBox();
    Label nameLabel = new Label();
    Label descriptionLabel = new Label();
    Label requestedAtLabel = new Label();
    Label clientInfoLabel = new Label();
    Button detailsButton = new Button();

    public PendingProjectCell(Project project) {
        super();
        _project = project;
        try {
            nameLabel.setText(project.getName());
            nameLabel.setFont(Font.font("Verdana", 20));
            nameLabel.setMaxWidth(Double.MAX_VALUE);

            descriptionLabel.setText(project.getDescription());
            descriptionLabel.setMaxWidth(Double.MAX_VALUE);

            if (project.getClient() != null) {
                clientInfoLabel.setText("Cliente: " + project.getClient().getFirstName() + " " + project.getClient().getLastName() + " - " + project.getClient().getOrganization());
                clientInfoLabel.setMaxWidth(Double.MAX_VALUE);

            }

            String deadlineAt = new SimpleDateFormat("dd-MM-yyyy").format(project.getCreatedAt());
            requestedAtLabel.setText("Solicitado el: " + deadlineAt);

            requestedAtLabel.setMaxWidth(Double.MAX_VALUE);

            HBox.setHgrow(vBox, Priority.ALWAYS);

            vBox.getChildren().addAll(nameLabel, descriptionLabel, clientInfoLabel, requestedAtLabel);
            detailsButton.setText("Evaluar");
            detailsButton.setOnAction((ActionEvent e) -> {
                EvaluateButtonClick(e);
            });

            this.getChildren().addAll(vBox, detailsButton);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void EvaluateButtonClick(ActionEvent e) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("firecamp/EditProject.fxml"));
            Scene scene = new Scene((Pane) loader.load());
            EditProjectController controller = loader.<EditProjectController>getController();
            controller.initData(_project);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(FireCamp.getMainStage());
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
