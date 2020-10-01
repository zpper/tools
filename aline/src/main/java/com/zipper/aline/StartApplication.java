package com.zipper.aline;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/19.
 */
public class StartApplication extends Application {

    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        loadIcon(primaryStage);

        Parent root = FXMLLoader.load(getClass().getResource("/home.fxml"));

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    private void loadIcon(Stage primaryStage) {
        stage = primaryStage;

        try {

            javafx.scene.image.Image image = new javafx.scene.image.Image(getClass().getResourceAsStream("/solomon.png"));
            stage.getIcons().add(image);
            stage.setIconified(true);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }


}
