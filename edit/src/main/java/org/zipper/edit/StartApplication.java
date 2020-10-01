package org.zipper.edit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class StartApplication extends Application {

    private static Stage stage;


    @Override
    public void start(Stage primaryStage) throws Exception {

        init(primaryStage);

        Parent root = FXMLLoader.load(getClass().getResource("/home.fxml"));

        Scene scene = new Scene(root, Screen.getPrimary().getBounds().getWidth() / 2, Screen.getPrimary().getBounds().getHeight() / 2);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    //初始化
    private void init(Stage primaryStage) {

        stage = primaryStage;

        try {
            //添加图标
            Image image = new Image(getClass().getResourceAsStream("/img/solomon.png"));
            stage.getIcons().add(image);
            stage.setIconified(true);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}