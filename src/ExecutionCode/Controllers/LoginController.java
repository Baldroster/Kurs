package ExecutionCode.Controllers;

import ExecutionCode.BaseObjects.User;
import ExecutionCode.Database.SqlQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonQuit;
    @FXML
    private TextField fieldLogin;
    @FXML
    private TextField fieldPassword;
    @FXML
    private Label exeptionLabel;
    @FXML
   

    private  String password ="pass";
    private  String login ="log";
    private User user = new User();
    @FXML
    private void clickButtonLogin() throws IOException, SQLException {
        user.setLog(fieldLogin.getCharacters().toString());
        user.setPass(fieldPassword.getCharacters().toString());
        if (SqlQuery.getUsers(user) == true){

            Stage stage = (Stage) fieldLogin.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("../Xmls/Main form.fxml"));
            stage = new Stage();
            stage.setTitle("Окно Log-in");
            stage.setScene(new Scene(root, 380, 400));
            stage.show();
        }
        else {
            exeptionLabel.setDisable(false);


        }
    }

    @FXML
    private void clickButtonQuit() {
        Stage stage = (Stage) buttonQuit.getScene().getWindow();
        stage.close();
    }
}
