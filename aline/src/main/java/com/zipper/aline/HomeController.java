package com.zipper.aline;

import javafx.fxml.FXML;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import sun.nio.ByteBuffered;
import sun.plugin2.gluegen.runtime.BufferFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.List;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/22.
 */
public class HomeController {

    @FXML
    private ImageView orgPane;

    @FXML
    private ImageView dupPane;

    public void loadSrc() {

        URL file = getClass().getResource("/img001.png");
        orgPane.setImage(new Image(file.toExternalForm()));

    }

    public void transform() {

        Image img = orgPane.getImage();

        dupPane.setImage(loadTransImg(img));

    }

    private Image loadTransImg(Image image) {

        System.out.println(image.getWidth());
        System.out.println(image.getHeight());

        PixelReader read = image.getPixelReader();


        WritableImage outImage = new WritableImage(read, 1920, 1080);
        for (int i = 0; i < 1080; i++) {
            //画一条红线
            outImage.getPixelWriter().setColor(20, i, Color.RED);
        }
        return outImage;
    }

}
