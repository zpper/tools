package com.zipper.aline;

import com.sun.imageio.plugins.common.ImageUtil;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.image.*;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;

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

        URL file = getClass().getResource("/solomon.png");
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


        WritableImage outImage = new WritableImage(read, (int) image.getWidth(), (int) image.getHeight());

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {

                Color color = read.getColor(i, j);
                if (color.getBlue() < 0.5 && color.getRed() < 0.5 && color.getGreen() < 0.5) {

                    outImage.getPixelWriter().setArgb(i, j, 0);
                } else {

                    outImage.getPixelWriter().setColor(i, j, Color.color(1 - color.getRed(), 1 - color.getGreen(), 1 - color.getBlue()));
                }
            }
        }


        return outImage;
    }

    //保存image到文件
    private void loadFile(WritableImage image) {
        String path = "E:\\workspaceAll\\gitee\\javafx\\edit\\src\\main\\resources\\img\\solomon.png";
        File outputFile = new File(path);
        if (outputFile.exists()) {
            outputFile.delete();
        }
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bImage, "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
