package ExecutionCode.Controllers;

import ExecutionCode.BaseObjects.Guest;
import ExecutionCode.BaseObjects.Worker;
import ExecutionCode.Database.SqlQuery;
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

public class WorkerInsertController {

    private Worker worker = new Worker();

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField fieldIdRoom;

    @FXML
    private TextField fieldId;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldSoname;

    @FXML
    private TextField fieldFather;

    @FXML
    private TextField fieldAge;

    @FXML
    private TextField fieldPhone;

    @FXML
    private TextField fieldPassport;

    @FXML
    private TextField fieldSalary;

    @FXML
    private Label errorLabel;

    @FXML
    private void clickBackButton() throws IOException {
        returnToMainWindow();
    }

    @FXML
    private void clickSaveButton() throws SQLException, IOException {
        receiveValueFromFields();
        if(worker.checkValidationInsert()){
            if (SqlQuery.checkNotDuplicateWorker(worker)){
                SqlQuery.setWorker(worker);
                returnToMainWindow();
            }
            else{
                clearTextAreas();
                errorLabel.setText("Данный работник уже существует");
                errorLabel.setVisible(true);
            }
        }
        else {
            clearTextAreas();
            errorLabel.setText("Введите верные значения");
            errorLabel.setVisible(true);
        }
    }

    private void clearTextAreas(){
        fieldIdRoom.setText("");
        fieldName.setText("");
        fieldSoname.setText("");
        fieldFather.setText("");
        fieldAge.setText("");
        fieldPhone.setText("");
        fieldPassport.setText("");
        fieldSalary.setText("");
    }
    private  void returnToMainWindow() throws IOException {
        Stage stage = (Stage) fieldIdRoom.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/Xmls/MainForm.fxml"));
        stage = new Stage();
        stage.setTitle("Главное Окно");
        stage.setScene(new Scene(root, 380, 400));
        stage.show();
    }

    private void receiveValueFromFields(){
        worker.setIdRoom(fieldIdRoom.getCharacters().toString());
        worker.setName(fieldName.getCharacters().toString());
        worker.setSoname(fieldSoname.getCharacters().toString());
        worker.setFather(fieldFather.getCharacters().toString());
        worker.setAge(fieldAge.getCharacters().toString());
        worker.setPhone(fieldPhone.getCharacters().toString());
        worker.setPassport(fieldPassport.getCharacters().toString());
        worker.setSalary(fieldSalary.getCharacters().toString());
    }
}
