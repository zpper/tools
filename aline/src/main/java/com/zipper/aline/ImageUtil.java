package com.zipper.aline;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/22.
 */
public class ImageUtil {

    //绘制骨架
    public Image getBone(Image image) {

        PixelReader read = image.getPixelReader();
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        WritableImage outImage = new WritableImage(read, width, height);

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {

                Color color = read.getColor(i, j);

                outImage.getPixelWriter().setColor(i, j, Color.color(color.getRed(), color.getBlue(), color.getGreen()));
            }
        }

        return outImage;

    }


//    private Color[][] turnColor(Color[][] colors) {
//
//
//        for (Color[] colors1 : colors) {
//            for (Color color : colors1) {
//                color.getHue()
//            }
//        }
//    }


}
