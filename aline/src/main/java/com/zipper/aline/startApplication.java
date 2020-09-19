package com.zipper.aline;

import com.sun.deploy.panel.GeneralPanel;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import sun.print.PSPrinterJob;
import sun.print.PeekGraphics;

import java.awt.*;
import java.util.List;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/19.
 */
public class startApplication extends Application {

    private Stage stage;
    private Canvas cv;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        stage = primaryStage;
        stage.setFullScreen(true);


        Group parent = new Group();
        Canvas cv = new Canvas();

        Scene sn = new Scene(parent, 1, 1);
        sn.setOnMouseClicked(e -> {
            System.out.println(e.getScreenX() + ":" + e.getScreenY());
            System.out.println(e.getSceneX() + ":" + e.getSceneY());
        });

        stage.setScene(sn);

        stage.setTitle("测试");
        stage.setMaxHeight(100);
        stage.setMaxWidth(100);

//        stage.setIconified(false);
        stage.show();

    }
}
