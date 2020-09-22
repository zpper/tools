package com.zipper.aline;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.net.URL;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/22.
 */
public class EditImg extends Application {

    @FXML
    private AnchorPane orgPane;

    @FXML
    private AnchorPane dupPane;


    private static void printPic(BufferedImage bi) {
        int[] rgb = new int[3];
        int width = bi.getWidth();
        int height = bi.getHeight();
        int minx = bi.getMinX();
        int miny = bi.getMinY();
        System.out.println("width=" + width + ",height=" + height + ".");
        System.out.println("minx=" + minx + ",miniy=" + miny + ".");
        for (
                int i = minx;
                i < width; i++) {
            for (int j = miny; j < height; j++) {
                //System.out.print(bi.getRGB(jw, ih));
                int pixel = bi.getRGB(i, j);
                rgb[0] = (pixel & 0xff0000) >> 16;
                rgb[1] = (pixel & 0xff00) >> 8;
                rgb[2] = (pixel & 0xff);
                //System.out.print("i="+i+",j="+j+":("+rgb[0]+","+rgb[1]+","+rgb[2]+")");
                int x = (rgb[0] + rgb[1] + rgb[2]) / 100;
                if (x == 7) {
                    System.out.print(" ");
                } else {
                    System.out.print(x);
                }

            }
            System.out.println();
        }


    }


    @Test
    public void diff() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getResource("/home.fxml"));

        URL file = getClass().getResource("/img001.png");

        ImageView img = new ImageView();
        img.setImage(new Image(file.toExternalForm()));
        orgPane.getChildren().add(img);

        Scene scene = new Scene(root, 500, 500);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();
//
//        BufferedImage bi = null;
//        try {
//            bi = ImageIO.read(file);
//
//
//            printPic(bi);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}