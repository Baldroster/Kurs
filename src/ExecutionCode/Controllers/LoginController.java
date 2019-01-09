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

    private User user = new User();
    @FXML
    private void clickButtonLogin() throws IOException, SQLException {
        user.setLog(fieldLogin.getCharacters().toString());
        user.setPass(fieldPassword.getCharacters().toString());
        if (SqlQuery.getUsers(user)){

            returnToMainWindow();
        }
        else {
            fieldLogin.setText("");
            fieldPassword.setText("");
            exeptionLabel.setVisible(true);


        }
    }

    @FXML
    private void clickButtonQuit() {
        Stage stage = (Stage) buttonQuit.getScene().getWindow();
        stage.close();
    }

    private  void returnToMainWindow() throws IOException {
        Stage stage = (Stage) fieldLogin.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/Xmls/MainForm.fxml"));
        stage = new Stage();
        stage.setTitle("Главное Окно");
        stage.setScene(new Scene(root, 380, 400));
        stage.show();
    }
}
