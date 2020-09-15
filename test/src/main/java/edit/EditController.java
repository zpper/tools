package edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.text.Text;

public class EditController {
    @FXML
    private Text actiontarget;

    @FXML
    MenuBar menuBar;


    public void saveAs(ActionEvent actionEvent) {
        System.out.println(actionEvent);
    }
}
