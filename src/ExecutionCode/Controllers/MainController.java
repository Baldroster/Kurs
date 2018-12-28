package ExecutionCode.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private Button buttonInputRoom;

    @FXML
    private void clickButtonInputRoom() throws IOException {
        Stage stage = (Stage) buttonInputRoom.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/Xmls/RoomInsert.fxml"));
        stage = new Stage();
        stage.setTitle("Окно ввод данных о комнату");
        stage.setScene(new Scene(root, 423, 382));
        stage.show();
    }

}
