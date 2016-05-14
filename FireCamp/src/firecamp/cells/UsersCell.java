package firecamp.cells;

import firecamp.HomeController;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javax.swing.event.ChangeListener;
import models.Privilege;
import models.User;
import services.PrivilegeService;
import services.UserService;

public class UsersCell extends HBox {

    User _user;
    User _currentUser;
    Privilege _userPrivilege;
    VBox vBox = new VBox();
    Label nameLabel = new Label();
    Label emailLabel = new Label();
    Label organizationLabel = new Label();
    Label positionLabel = new Label();
    ImageView pictureImageView = new ImageView();
    ComboBox<TextCell> privilegeComboBox = new ComboBox<>();
    Button blockButton = new Button();

    public UsersCell(User currentUser, User user, Privilege userPrivilege) {
        super(30);
        _user = user;
        _currentUser = currentUser;
        _userPrivilege = userPrivilege;
        try {
            pictureImageView = ImageViewBuilder.create()
                    .image(new Image(user.getPicture()))
                    //.image(new Image("/resources/picture_placeholder.jpg"))
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

        getPrivileges();

        privilegeComboBox.valueProperty().addListener(new javafx.beans.value.ChangeListener<TextCell>() {
            @Override
            public void changed(ObservableValue<? extends TextCell> observable, TextCell oldValue, TextCell newValue) {
                Privilege newPrivilege = (Privilege) newValue.Model;
                newPrivilege.setCreatedBy(_currentUser);
                try {
                    PrivilegeService.getInstance().InsertOrUpdate(newPrivilege);
                } catch (Exception ex) {
                }
            }
        });

        this.getChildren().addAll(pictureImageView, vBox, privilegeComboBox, blockButton);
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
            alert.setHeaderText("No se guardaron los cambis");
            alert.setContentText("Hubo un error al intentar guardar estos cambios");
            alert.showAndWait();
        }
    }

    private void getPrivileges() {
        try {
            User user = new User();
            // Privileges definition
            List<TextCell> itemsListist = new ArrayList<>();

            Privilege undefinedPrivilege = new Privilege();
            undefinedPrivilege.setUser(_user);
            undefinedPrivilege.setLevel(0);
            TextCell<Privilege> undefinedPrivilegeCell = new TextCell<>(undefinedPrivilege, undefinedPrivilege.LevelName());
            itemsListist.add(undefinedPrivilegeCell);

            Privilege sysAdminPrivilege = new Privilege();
            sysAdminPrivilege.setUser(_user);
            sysAdminPrivilege.setLevel(1);
            TextCell<Privilege> sysAdminPrivilegeCell = new TextCell<>(sysAdminPrivilege, sysAdminPrivilege.LevelName());
            itemsListist.add(sysAdminPrivilegeCell);

            Privilege administratPrivilege = new Privilege();
            administratPrivilege.setUser(_user);
            administratPrivilege.setLevel(2);
            TextCell<Privilege> administratPrivilegeCell = new TextCell<>(administratPrivilege, administratPrivilege.LevelName());
            itemsListist.add(administratPrivilegeCell);

            Privilege internaPrivilege = new Privilege();
            internaPrivilege.setUser(_user);
            internaPrivilege.setLevel(3);
            TextCell<Privilege> internaPrivilegeCell = new TextCell<>(internaPrivilege, internaPrivilege.LevelName());
            itemsListist.add(internaPrivilegeCell);

            Privilege externalPrivilege = new Privilege();
            externalPrivilege.setUser(_user);
            externalPrivilege.setLevel(4);
            TextCell<Privilege> externalPrivilegeCell = new TextCell<>(externalPrivilege, externalPrivilege.LevelName());
            itemsListist.add(externalPrivilegeCell);

            ObservableList<TextCell> observableList = FXCollections.observableList(itemsListist);
            privilegeComboBox.setItems(observableList);

            int userPrivilegeLevel = _userPrivilege.getLevel();
            switch (userPrivilegeLevel) {
                case 1:
                    privilegeComboBox.getSelectionModel().select(sysAdminPrivilegeCell);
                    privilegeComboBox.setValue(sysAdminPrivilegeCell);
                    break;
                case 2:
                    privilegeComboBox.getSelectionModel().select(administratPrivilegeCell);
                    privilegeComboBox.setValue(administratPrivilegeCell);
                    break;
                case 3:
                    privilegeComboBox.getSelectionModel().select(internaPrivilegeCell);
                    privilegeComboBox.setValue(internaPrivilegeCell);
                    break;
                case 4:
                    privilegeComboBox.getSelectionModel().select(externalPrivilegeCell);
                    privilegeComboBox.setValue(externalPrivilegeCell);
                    break;
                default:
                    privilegeComboBox.getSelectionModel().select(undefinedPrivilegeCell);
                    privilegeComboBox.setValue(undefinedPrivilegeCell);
                    break;
            }
            privilegeComboBox.setPromptText(privilegeComboBox.getConverter().toString(privilegeComboBox.getValue()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
