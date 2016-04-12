package firecamp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FireCamp extends Application
{

    private static Stage _mainStage;

    // Getters    
    public static Stage getMainStage()
    {
        return _mainStage;
    }

    @Override
    public void start(Stage stage) throws Exception
    {        
        _mainStage = stage;
        
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
