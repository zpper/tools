package edit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Edit extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/edit/edit.fxml"));

        stage.setTitle("编辑器");
        stage.setScene(new Scene(root, 300, 275));
        this.stage = stage;
        stage.show();
    }

//    public static void  onSwitch() throws IOException {
//        Parent root = FXMLLoader.load(FXMLExample.class.getResource("/onswich/second.fxml"));
//        stage.setTitle("FXML Welcome");
//        stage.setScene(new Scene(root, 300, 275));
//        stage.show();
//    }

    public static void start(String[] args) {
        Application.launch(Edit.class, args);
    }
}