package ExecutionCode.Controllers;


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
import java.util.ArrayList;
import java.util.List;

public class WorkerSearchController {
    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    @FXML
    private Button previousButton;

    @FXML
    private Button nextButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button searchButton;

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

    private Worker worker = new Worker();
    private List<Worker> searchedWorkers = new ArrayList();
    private int index = 0;

    @FXML
    private void clickSearchButton() throws SQLException {
        receiveValueFromFields();
        if(worker.checkValidation()){
            if(SqlQuery.checkStatementDoesExist(SqlQuery.generateSqlSearchWorker(worker)))
            {
                searchedWorkers = SqlQuery.getWorkerQuery(SqlQuery.generateSqlSearchWorker(worker));
                fillTextareas();
                convertWindowIntoSearchResults();
            }
            else {
                clearTextAreas();
                errorLabel.setText("Значений не найдено");
                errorLabel.setVisible(true);
            }
        }
        else {
            clearTextAreas();
            errorLabel.setText("Введите верные значения");
            errorLabel.setVisible(true);
        }
    }

    @FXML
    private void clickNextButton(){
        index++;
        disableNavigateButtons();
        fillTextareas();
    }

    @FXML
    private void clickPreviousButton(){
        index--;
        disableNavigateButtons();
        fillTextareas();
    }

    @FXML
    private void clickSaveButton() throws IOException, SQLException {
        receiveValueFromFields();
        if(worker.checkValidationInsert()){

            receiveValueFromFields();
            SqlQuery.deleteWorker(worker);
            SqlQuery.setWorker(worker);
            returnToMainWindow();
        }
        else {
            fillTextareas();
            errorLabel.setText("Введите верные значения");
            errorLabel.setVisible(true);
        }
    }

    @FXML
    private void clickDeleteButton() throws IOException, SQLException {
        receiveValueFromFields();
        SqlQuery.deleteWorker(worker);
        returnToMainWindow();
    }

    @FXML
    private void clickBackButton() throws IOException {
        returnToMainWindow();
    }

    private  void returnToMainWindow() throws IOException {
        Stage stage = (Stage) fieldId.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/Xmls/MainForm.fxml"));
        stage = new Stage();
        stage.setTitle("Главное Окно");
        stage.setScene(new Scene(root, 380, 400));
        stage.show();
    }

    private void clearTextAreas(){
        fieldId.setText("");
        fieldIdRoom.setText("");
        fieldName.setText("");
        fieldSoname.setText("");
        fieldFather.setText("");
        fieldAge.setText("");
        fieldPhone.setText("");
        fieldPassport.setText("");
        fieldSalary.setText("");
    }

    private void convertWindowIntoSearchResults(){
        saveButton.setVisible(true);
        nextButton.setVisible(true);
        previousButton.setVisible(true);
        deleteButton.setVisible(true);
        searchButton.setVisible(false);
        disableNavigateButtons();
        fieldId.setDisable(true);
    }

    private void disableNavigateButtons(){
        if(searchedWorkers.size()-1 == index)
        {
            nextButton.setDisable(true);
        }
        else{
            nextButton.setDisable(false);
        }
        if(index == 0){
            previousButton.setDisable(true);
        }
        else{
            previousButton.setDisable(false);
        }
    }

    private void fillTextareas(){
        fieldId.setText(searchedWorkers.get(index).getId());
        fieldIdRoom.setText(searchedWorkers.get(index).getIdRoom());
        fieldName.setText(searchedWorkers.get(index).getName());
        fieldSoname.setText(searchedWorkers.get(index).getSoname());
        fieldFather.setText(searchedWorkers.get(index).getFather());
        fieldAge.setText(searchedWorkers.get(index).getAge());
        fieldPhone.setText(searchedWorkers.get(index).getPhone());
        fieldPassport.setText(searchedWorkers.get(index).getPassport());
        fieldSalary.setText(searchedWorkers.get(index).getSalary());
    }

    private void receiveValueFromFields(){
       worker.setId(fieldId.getCharacters().toString());
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



