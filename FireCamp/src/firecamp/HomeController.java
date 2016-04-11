package firecamp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import models.User;

public class HomeController implements Initializable
{

    @FXML
    private ListView activeProjectsListView;
    private User _currentUser;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        activeProjectsListView = new ListView();
        ObservableList<String> items = FXCollections.observableArrayList(
                "Single", "Double", "Suite", "Family App");
        activeProjectsListView.setItems(items);
    }

    public void initData(User user)
    {
        _currentUser = user;

//        ObservableList items = FXCollections.observableArrayList(
//                "Single", "Double", "Suite", "Family App");
//        activeProjectsListView = new ListView(items);
        //activeProjectsListView.setItems(items);
    }
}
