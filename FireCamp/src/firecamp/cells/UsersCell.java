package firecamp.cells;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import models.User;

public class UsersCell extends HBox {

    VBox vBox = new VBox();
    Label nameLabel = new Label();
    Label emailLabel = new Label();
    Label organizationLabel = new Label();
    Label positionLabel = new Label();
    ImageView pictureImageView = new ImageView();
    Button blockButton = new Button();

    public UsersCell(User user) {
        super(30);

        try {
            pictureImageView = ImageViewBuilder.create()
                    .image(new Image(user.getPicture()))
                    .build();
            pictureImageView.setPreserveRatio(false);
            pictureImageView.setFitHeight(100);
            pictureImageView.setFitWidth(100);
        } catch (Exception e) {

        }

        nameLabel.setText(user.getFirstName() + " " + user.getLastName());
        nameLabel.setFont(Font.font("Verdana", 15));
        nameLabel.setMaxWidth(Double.MAX_VALUE);

        emailLabel.setText(user.getEmail());
        emailLabel.setMaxWidth(Double.MAX_VALUE);

        organizationLabel.setText("Empresa: " + user.getOrganization());
        organizationLabel.setMaxWidth(Double.MAX_VALUE);

        positionLabel.setText("Puesto: " + user.getPosition());
        positionLabel.setMaxWidth(Double.MAX_VALUE);

        HBox.setHgrow(vBox, Priority.ALWAYS);

        vBox.getChildren().addAll(nameLabel, emailLabel, organizationLabel, positionLabel);
        blockButton.setText("Bloquear");

        this.getChildren().addAll(pictureImageView, vBox, blockButton);
    }
}
