package ExecutionCode;

import ExecutionCode.Database.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
Database database = new Database();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Database database = new Database();
        database.Initialize();
        database.cleanup();
        Parent root = FXMLLoader.load(getClass().getResource("../Xmls/login.fxml"));
        primaryStage.setTitle("Окно Log-in");
        primaryStage.setScene(new Scene(root, 568, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);

    }






}
