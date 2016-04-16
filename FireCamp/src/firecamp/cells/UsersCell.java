package firecamp.cells;

import firecamp.HomeController;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
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
import services.UserService;

public class UsersCell extends HBox {

    User _user;
    User _currentUser;
    VBox vBox = new VBox();
    Label nameLabel = new Label();
    Label emailLabel = new Label();
    Label organizationLabel = new Label();
    Label positionLabel = new Label();
    ImageView pictureImageView = new ImageView();
    Button blockButton = new Button();

    public UsersCell(User currentUser, User user) {
        super(30);
        _user = user;
        _currentUser = currentUser;
        try {
            pictureImageView = ImageViewBuilder.create()
                    //.image(new Image(user.getPicture()))
                    .image(new Image("/resources/picture_placeholder.jpg"))
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
        if (user.getIsActive()) {
            blockButton.setText("Bloquear");
        } else {
            blockButton.setText("Desbloquear");
        }
        blockButton.setOnAction((ActionEvent e) -> {
            EvaluateButtonClick(e);
        });

        this.getChildren().addAll(pictureImageView, vBox, blockButton);
    }

    private void EvaluateButtonClick(ActionEvent e) {
        try {
            _user.setIsActive(!_user.getIsActive());
            UserService.getInstance().InsertOrUpdate(_user);
            HomeController.getInstance().LoadUsers();
        } catch (Exception ex) {
            System.out.println(ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se guardaron los camobis");
            alert.setContentText("Hubo un error al intentar guardar estos cambios");
            alert.showAndWait();
        }
    }
}
