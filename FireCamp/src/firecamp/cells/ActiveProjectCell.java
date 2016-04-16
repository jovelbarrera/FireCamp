package firecamp.cells;

import java.text.SimpleDateFormat;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import models.Project;

public class ActiveProjectCell extends HBox {

    VBox vBox = new VBox();
    Label nameLabel = new Label();
    Label descriptionLabel = new Label();
    Label clientInfoLabel = new Label();
    Label managerInfoLabel = new Label();
    Label deadlineLabel = new Label();
    Button detailsButton = new Button();

    public ActiveProjectCell(Project project) {
        super();

        nameLabel.setText(project.getName());
        nameLabel.setFont(Font.font("Verdana", 20));
        nameLabel.setMaxWidth(Double.MAX_VALUE);

        descriptionLabel.setText(project.getDescription());
        descriptionLabel.setMaxWidth(Double.MAX_VALUE);

        if (project.getClient() != null) {
            clientInfoLabel.setText("Cliente: " + project.getClient().getFirstName() + " " + project.getClient().getLastName() + " - " + project.getClient().getOrganization());
            clientInfoLabel.setMaxWidth(Double.MAX_VALUE);

        }

        if (project.getManager() != null) {
            managerInfoLabel.setText("Project Manager: " + project.getManager().getFirstName() + " " + project.getManager().getLastName() + " - " + project.getManager().getOrganization());
            managerInfoLabel.setMaxWidth(Double.MAX_VALUE);
        }

        String deadlineAt = new SimpleDateFormat("dd-MM-yyyy").format(project.getDeadlineAt());
        deadlineLabel.setText("Fecha de entrega: " + deadlineAt);

        deadlineLabel.setMaxWidth(Double.MAX_VALUE);

        HBox.setHgrow(vBox, Priority.ALWAYS);

        vBox.getChildren().addAll(nameLabel, descriptionLabel, clientInfoLabel, managerInfoLabel, deadlineLabel);
        detailsButton.setText("Ver detalles");

        this.getChildren().addAll(vBox);
    }
}
