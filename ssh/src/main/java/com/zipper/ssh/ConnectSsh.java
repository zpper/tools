package com.zipper.ssh;

import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/01/27.
 */
public class ConnectSsh implements Runnable {

    private static String baseHome = "cd /home/EDR-AGENT";

    private static Logger logger = LoggerFactory.getLogger(ConnectSsh.class);

    private String devHost;

    private static final String SUFFIX = "\n";

    public ConnectSsh(String devHost) {
        this.devHost = devHost;
    }

    public static List<String> writeList;

    static {
        writeList = new ArrayList<String>();
//        writeList.add("192.168.1.168");
//        writeList.add("192.168.1.155");
//        writeList.add("192.168.1.200");
//        writeList.add("192.168.1.162");
//        writeList.add("192.168.1.154");
//        writeList.add("192.168.1.152");
//        writeList.add("192.168.1.163");
//        writeList.add("192.168.1.180");
//        writeList.add("192.168.1.160");
//        writeList.add("192.168.1.171");
//        writeList.add("192.168.1.167");
//        writeList.add("192.168.1.175");
//        writeList.add("192.168.1.157");
//        writeList.add("192.168.1.164");
//        writeList.add("192.168.1.166");
//        writeList.add("192.168.1.156");
//        writeList.add("192.168.1.190");
//        writeList.add("192.168.1.159");
//        writeList.add("192.168.1.151");
//        writeList.add("192.168.1.179");
//        writeList.add("192.168.1.182");
//        writeList.add("192.168.1.177");
//        writeList.add("192.168.1.149");
//        writeList.add("192.168.1.176");
//        writeList.add("192.168.1.148");
//        writeList.add("192.168.1.150");
//        writeList.add("192.168.1.161");
//        writeList.add("192.168.1.173");
//        writeList.add("192.168.1.158");
//        writeList.add("192.168.1.181");
//        writeList.add("192.168.1.183");
//        writeList.add("192.168.1.165");
//        writeList.add("192.168.1.185");
//        writeList.add("192.168.1.170");
//        writeList.add("192.168.1.186");


        writeList.add("192.168.1.141");
        writeList.add("192.168.1.146");
        writeList.add("192.168.1.199");
        writeList.add("192.168.1.206");
        writeList.add("192.168.1.134");
        writeList.add("192.168.1.123");
        writeList.add("192.168.1.201");
        writeList.add("192.168.1.136");
        writeList.add("192.168.1.135");
        writeList.add("192.168.1.124");
        writeList.add("192.168.1.145");
        writeList.add("192.168.1.147");
        writeList.add("192.168.1.119");
        writeList.add("192.168.1.200");
        writeList.add("192.168.1.125");
        writeList.add("192.168.1.207");
        writeList.add("192.168.1.103");
        writeList.add("192.168.1.118");
        writeList.add("192.168.1.120");
        writeList.add("192.168.1.113");

    }


    public static void start(String[] args) {
        for (String ip : writeList) {
            ConnectSsh sshUpload = new ConnectSsh(ip);
            Thread t = new Thread(sshUpload);
            t.setName("agent :" + ip);
            t.start();
        }
    }

    public static void upload(String host) {
        ChannelShell channel = null;
        Session session = null;
        try {

            JSch jsch = new JSch();
            session = jsch.getSession("root", host, 22);
            // 设置密码
//            session.setPassword("Zkqa123.");
            session.setPassword("123456");
            //需要实现Jsch包中的UserInfo,UIKeyboardInteractive接口，用以保存用户信息，以及进行键盘交互式认证并执行命令。
            session.setUserInfo(new MyUserInfo());
            Properties config = new Properties();
            //在代码里需要跳过检测。否则会报错找不到主机
            config.put("StrictHostKeyChecking", "no");
            // 为Session对象设置properties
            session.setConfig(config);
            int timeout = 30000;
            // 设置timeout时间
            session.setTimeout(timeout);
            // 通过Session建立与远程服务器的连接回话
            session.connect();
            channel = (ChannelShell) session.openChannel("shell");
            channel.connect();
            InputStream inputStream = channel.getInputStream();
            OutputStream outputStream = channel.getOutputStream();

            String cmd = baseHome + " \n\r";
            outputStream.write(cmd.getBytes());


            doaction(outputStream);

            //other section
            outputStream.write("exit\n".getBytes());
            outputStream.flush();

            Sout sout = new Sout(inputStream);
            new Thread(sout).start();

            while (true) {
                sout.setExit();
                Thread.sleep(3000);
                if (sout.getExit()) {
                    outputStream.close();
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.disconnect();
            session.disconnect();
            logger.info(host + "\t 结束");
        }
    }

    private static void doaction(OutputStream outputStream) {

        //更新配置
//            outputStream.write(new StringBuilder().append("cd ").append(baseHome).append("\n").toString().getBytes());
//            outputStream.write("python agent_monitor.py &\n".getBytes());
//            start(outputStream);
//            outputStream.write("iptables -A INPUT -p tcp --dport 80 -j ACCEPT \n\r".getBytes());
//            moveConfig(outputStream);
        start(outputStream);

    }

    /**
     * @param outputStream
     */
    private static void updateJar(OutputStream outputStream) {
        try {

            String jarName = "agent-1.0.6.jar";
            String mavenFile = " http://192.168.1.11:8081/repository/host-repo/cn/ac/ist/agent/terminal-agent/0.0.2/terminal-agent-0.0.2.jar";
            String auth = " -u common:def123456 ";
            outputStream.write(new StringBuilder()
                    .append("rm -f ")
                    .append(jarName)
                    .append(SUFFIX).toString().getBytes());
            outputStream.write(new StringBuilder()
                    .append("curl -o ")
                    .append(jarName)
                    .append(auth)
                    .append(mavenFile)
                    .append(SUFFIX).toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param outputStream 输出流
     */
    private static void updateShell(OutputStream outputStream) {
        try {

            List<String> lines = FileUtils.readLines(new File("E:\\workspaceAll\\auto-deploy.sh"), "utf-8");
            for (String line : lines) {
                String cmdLine = line + "\n\r";
                outputStream.write(cmdLine.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void moveConfig(OutputStream outputStream) {
        try {
            outputStream.write("cd /home/EDR-AGENT/config/\n".getBytes());
            outputStream.write("rm -rf iptables-v1 \n".getBytes());
            outputStream.write("ps -ef|grep zkqa-terminal-ag-3.9.0.jar |awk '{print(\"kill \",$2)}'|kill   \n".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void start(OutputStream outputStream) {
        try {
            outputStream.write("cd /home/EDR-AGENT\n".getBytes());
            outputStream.write("./agent_init.sh  zkqa-terminal-ag-monitor-0.0.2.jar\r\n".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void run() {
        upload(devHost);
    }
}
