package ExecutionCode;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {
    @FXML
    private Button buttonInputRoom;

    @FXML
    private void clickButtonInputRoom() {
        buttonInputRoom.setText("You've clicked!");
    }

}
