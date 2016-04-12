package firecamp;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import models.User;

public class HomeController implements Initializable {

    @FXML
    private ListView<ActiveProjectCell> activeProjectsListView;

    public static class ActiveProjectCell extends HBox {

        Label firstnameLabel = new Label();
        Label lastnameLabel = new Label();
        Button button = new Button();

        ActiveProjectCell(User user) {
            super();

            firstnameLabel.setText(user.getFirstName());
            firstnameLabel.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(firstnameLabel, Priority.ALWAYS);

            lastnameLabel.setText(user.getFirstName());
            lastnameLabel.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(firstnameLabel, Priority.ALWAYS);

            button.setText(user.getEmail());

            this.getChildren().addAll(firstnameLabel, lastnameLabel, button);
        }
    }

    private User _currentUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
    }

    public void initData(User user) {
        _currentUser = user;
        
        List<ActiveProjectCell> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add(new ActiveProjectCell(_currentUser));
        }
        ObservableList<ActiveProjectCell> myObservableList = FXCollections.observableList(list);
        activeProjectsListView.setItems(myObservableList);
    }
}
