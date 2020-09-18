package com.zipper.xff;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Consumer;
import java.util.regex.Pattern;


public class FXMLSecondController {

    private static String allowPath;

    //标准IPv4地址的正则表达式：
    private static final Pattern IPV4_REGEX = Pattern.compile("(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}");

    private static final Pattern IPV4_REGEX_CI = Pattern.compile("(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\/\\d+");
    //无全0块，标准IPv6地址的正则表达式
    private static final Pattern IPV6_STD_REGEX = Pattern.compile("([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}");
    //压缩正则表达式
    private static final Pattern IPV6_COMPRESS_REGEX = Pattern.compile("(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4})*)?)::((([0-9A-Fa-f]{1,4}:)*[0-9A-Fa-f]{1,4})?)");

    static {
        String parent = System.getProperty("user.dir");
        allowPath = parent + File.separator + "allow.txt";
    }

    @FXML
    private TextField searchText;

    @FXML
    private TextArea outText;

    @FXML
    private javafx.scene.text.Text error;

    private List<IpInfo> allowIpList;

    public FXMLSecondController() {

        super();

        allowIpList = new ArrayList<>();

        File file = new File(allowPath);

        if (file.exists() && file.isFile()) {

            FileInputStream in = null;

            try {

                in = new FileInputStream(file);

                BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));

                String line = null;

                while ((line = br.readLine()) != null) {

                    IpInfo ipInfo = getIpInfo(line);

                    if (ipInfo != null) {

                        allowIpList.add(ipInfo);
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            try {
                System.out.println("创建\n" + file.getName());
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    //提取IP信息
    private IpInfo getIpInfo(String line) {
        IpInfo ipInfo = null;
        if (line != null && !"".equals(line.trim())) {
            StringTokenizer tk = new StringTokenizer(line);

            ipInfo = new IpInfo();

            try {

                int i = 0;

                while (tk.hasMoreTokens()) {
                    String token = tk.nextToken();
                    if (i == 0) {
                        ipInfo.setIp(token);
                    } else if (i == 1) {
                        ipInfo.setTitle(token);
                    }
                    i++;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        return ipInfo;
    }


    /**
     * 添加白名单
     *
     * @param actionEvent
     */
    public void addToAllowIp(javafx.event.ActionEvent actionEvent) {

        File file = new File(allowPath);

        String inputValue = searchText.getCharacters().toString().trim();

        if (!isAllowIp(inputValue)) {
            return;
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("文件创建失败:" + file.getName());
            }
        }


        try (OutputStream out = new FileOutputStream(file, true);) {


            IpInfo ipInfo = getIpInfo(inputValue);

            if (ipInfo != null) {
                String outLine = ipInfo.getIp() + "\t" + (ipInfo.getTitle() == null ? "" : ipInfo.getTitle()) + "\n";
                out.write(outLine.getBytes("utf-8"));
                out.flush();
            } else {
                error.setText(inputValue + "\t格式不正确");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        allowIpList.add(getIpInfo(inputValue));
        outText.setEditable(false);
        refresh();

    }

    public void matchInputIp(javafx.event.ActionEvent actionEvent) {
        String inputValue = searchText.getCharacters().toString();

        ChangeListener cl = new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                dealWithInput(inputValue);
            }
        };
        searchText.textProperty().addListener(cl);

        StartApplication.addListener(new Consumer<String>() {
            @Override
            public void accept(String s) {

                if (null != s && !"".equals(s)) {

                    dealWithInput(s.trim());
                }

            }
        });

        refresh();
    }


    //-------------------------------------------------------------------------

    public void dealWithInput(String inputValue) {
        if (inputValue == null || "".equals(inputValue)
                || !isAllowIp(inputValue)) {
            return;
        }

        IpInfo allowIp = null;

        for (IpInfo ipInfo : allowIpList) {

            String ip = ipInfo.getIp();

            if (ip.contains("/") && isInRange(inputValue, ip)) {
                allowIp = ipInfo;
                break;
            }
            if (ip.contains("-") && ipExistsInRange(inputValue, ip)) {
                allowIp = ipInfo;
                break;
            }
            if (ip.equals(inputValue)) {
                allowIp = ipInfo;
                break;
            }
        }
        if (allowIp != null) {
            error.setUnderline(true);
            error.setText("白名单:\t" + (allowIp.getTitle() == null ? "" : allowIp.getTitle()) + "\n" + inputValue);
        } else {

            error.setUnderline(false);
            error.setText("非白名单:\n" + inputValue);
        }
    }

    private boolean isAllowIp(String inputValue) {

        boolean rbet = false;

        if (IPV4_REGEX.matcher(inputValue).find()
                || IPV4_REGEX_CI.matcher(inputValue).find()) {

            if (inputValue.contains("/")) {
                int type = Integer.parseInt(inputValue.replaceAll(".*/", ""));

                if (type < 32 && type > 0) {

                    String cidrIp = inputValue.replaceAll("/.*", "");

                    rbet = true;
                } else {
                    error.setText(inputValue + "不合法的格式");
                }

            } else {
                rbet = true;
            }

            //继续下一条

        } else if (IPV6_COMPRESS_REGEX.matcher(inputValue).find()
                || IPV6_STD_REGEX.matcher(inputValue).find()) {

            error.setText("输入IPv6格式暂不支持");


        } else if (allowIpList.contains(inputValue.trim())) {
            error.setText(inputValue + "已存在，请勿重复添加");

        } else {

            error.setText(inputValue + "非法的IP格式");

        }

        return rbet;
    }


    private void refresh() {
        outText.clear();

        allowIpList.forEach(i -> {
            if (null != i) {
                outText.appendText((i.getTitle() == null ? "" : i.getTitle()) + "\t" + i.getIp() + "\n");
            }
        });
    }


    public static boolean ipExistsInRange(String ip, String ipSection) {

        ipSection = ipSection.trim();

        ip = ip.trim();

        int idx = ipSection.indexOf('-');

        String beginIP = ipSection.substring(0, idx);

        String endIP = ipSection.substring(idx + 1);

        return getIp2long(beginIP) <= getIp2long(ip) && getIp2long(ip) <= getIp2long(endIP);

    }

    public static long getIp2long(String ip) {

        ip = ip.trim();

        String[] ips = ip.split("\\.");

        long ip2long = 0L;

        for (int i = 0; i < 4; ++i) {

            ip2long = ip2long << 8 | Integer.parseInt(ips[i]);

        }

        return ip2long;

    }

    public static boolean isInRange(String ip, String cidr) {
        String[] ips = ip.split("\\.");
        int ipAddr = (Integer.parseInt(ips[0]) << 24)
                | (Integer.parseInt(ips[1]) << 16)
                | (Integer.parseInt(ips[2]) << 8) | Integer.parseInt(ips[3]);
        int type = Integer.parseInt(cidr.replaceAll(".*/", ""));
        int mask = 0xFFFFFFFF << (32 - type);
        String cidrIp = cidr.replaceAll("/.*", "");
        String[] cidrIps = cidrIp.split("\\.");
        int cidrIpAddr = (Integer.parseInt(cidrIps[0]) << 24)
                | (Integer.parseInt(cidrIps[1]) << 16)
                | (Integer.parseInt(cidrIps[2]) << 8)
                | Integer.parseInt(cidrIps[3]);

        return (ipAddr & mask) == (cidrIpAddr & mask);
    }

}