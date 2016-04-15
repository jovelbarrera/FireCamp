package firecamp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import models.Project;

public class EditProjectController implements Initializable {

    private Project _project;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void initData(Project project) {
        _project = project;
    }

}
