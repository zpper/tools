package com.zipper.aline;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.junit.Test;


public class HiddenState extends Application {

    {


//        Pane root = new Pane();
//        ImageView img = new ImageView();
//        img.setImage(new Image(getClass().getResource("/panel.png").toExternalForm()));
//        root.getChildren().add(img);

       /* Button bt = new Button("hhh");

        bt.backgroundProperty().set(Background.EMPTY);

        root.getChildren().add(bt);*/


//        Scene scene = new Scene(root, 500, 500);
//        scene.setFill(Color.TRANSPARENT);
//        stage.initStyle(StageStyle.TRANSPARENT);
//        stage.setScene(scene);
//        stage.show();
    }

    @Override
    public void start(Stage primaryStage) {


        try {

            HBox hbox = new HBox();
            hbox.setSpacing(12);

            Button button1 = new Button("Button 1");

            Button button2 = new Button("Button 2");
            Button button3 = new Button("Button 3");

            hbox.getChildren().addAll(button1, button2, button3);

            Scene scene = new Scene(hbox, Color.TRANSPARENT);

//          scene.getStylesheets().add( getClass().getResource("application.css").toExternalForm());
            scene.getRoot().setStyle("-fx-background-color: transparent");
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.show();

            button1.setOnAction(e -> {
                Rectangle rt = new Rectangle(0, 0, 50, 50);
                rt.setFill(Color.TRANSPARENT);
                rt.setStyle("-fx-background-color: transparent");
                Pane gp = new Pane(rt);

                Scene ss = new Scene(gp, Color.TRANSPARENT);
                primaryStage.setScene(ss);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void starApp() {
        launch();
    }
}