package com.zipper.ssh;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/01/27.
 */
public class Connect {

    private static String cmd = "cd /home";

    private static Logger logger = LoggerFactory.getLogger(Connect.class);

//    public static void main(String[] args) {
//
//        try {
//
//            JSch jsch = new JSch();
//            Session session = jsch.getSession("root", "192.168.1.147", 22);
//            session.setPassword("Zkqa123."); // 设置密码
//            session.setUserInfo(new MyUserInfo()); //需要实现Jsch包中的UserInfo,UIKeyboardInteractive接口，用以保存用户信息，以及进行键盘交互式认证并执行命令。
//            Properties config = new Properties();
//            config.put("StrictHostKeyChecking", "no");//在代码里需要跳过检测。否则会报错找不到主机
//            session.setConfig(config); // 为Session对象设置properties
//            int timeout = 30000;
//            session.setTimeout(timeout); // 设置timeout时间
//            session.connect(); // 通过Session建立与远程服务器的连接回话
//
//            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
//            channelExec.setCommand(cmd);         //添加传入进来的shell命令
//            channelExec.setCommand("pwd");
//            channelExec.setInputStream(null);
//            channelExec.setErrStream(System.err);//通道连接错误信息提示
//            channelExec.connect();
//            logger.info("start execute channel command!");
//            BufferedReader in = new BufferedReader(new InputStreamReader(channelExec.getInputStream()));
//            String msg;
//            logger.info("start read!");
//            while ((msg = in.readLine()) != null) {
//                logger.info("命令返回信息：{}", msg);
//            }
//            in.close();
//            channelExec.disconnect();
//            logger.info("end execute channel command!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
