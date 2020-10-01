package org.zipper.edit;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.junit.Test;


/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/29.
 */
public class TransFormPng extends Application {

    @Test
    public void exportPng() {
        launch();
    }

    private Image transForm(Image image) {

        PixelReader read = image.getPixelReader();

        WritableImage outImage = new WritableImage(read, (int) image.getWidth(), (int) image.getHeight());

        for (int i = 0; i < outImage.getWidth(); i++) {
            for (int j = 0; j < outImage.getHeight(); j++) {

                Color color = read.getColor(i, j);
                outImage.getPixelWriter().setColor(i, j, Color.color(color.getRed(), color.getBlue(), color.getGreen()));
            }
        }

        return outImage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Image img = transForm(new Image(TransFormPng.class.getResourceAsStream("/solomon.jpg")));
//        ImageView imgv = new ImageView();
//        Scene sc = new Scene();
//        primaryStage.setScene(sc);
//        primaryStage.show();
    }

}
