package test;

//例子二：

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class RobotExp {


    public static void start(String[] args) {
        try {
            try {
                Runtime.getRuntime().exec("notepad");//打开notepad
            } catch (IOException e) {
                // TODO 自动生成 catch 块
                e.printStackTrace();
            }
            Robot robot = new Robot();
            //定义3秒的延迟开始写
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_H);
            robot.keyPress(KeyEvent.VK_I);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyPress(KeyEvent.VK_S);
            robot.keyPress(KeyEvent.VK_X);
            robot.keyPress(KeyEvent.VK_C);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}
