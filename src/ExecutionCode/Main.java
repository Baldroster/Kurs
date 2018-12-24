package ExecutionCode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../Xmls/login.fxml"));
        primaryStage.setTitle("Окно Log-in");
        primaryStage.setScene(new Scene(root, 568, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }






}
