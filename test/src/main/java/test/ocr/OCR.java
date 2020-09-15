package test.ocr;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class OCR {

    public static void start() {
        ITesseract instance = new Tesseract();
        try {
//            File file = new File("D:\\JTOK\\error-logs\\tmp\\c24b14d789e6345af8bf04768916854.png");
//            ImageIO.read()
//            instance.setLanguage("chinese");
//            System.out.println(dia);
//            System.out.println("doOCR on a jpg image");
//            File imageFile = new File(this.testResourcesDataPath, "ocr.png");
            //set language
//            instance.setDatapath("D:\\JTOK\\error-logs\\tmp\\c24b14d789e6345af8bf04768916854.png");
            File imageFile = new File("E:\\workspaceAll", "temp.png");
            instance.setLanguage("eng");
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
