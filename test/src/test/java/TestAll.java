import org.junit.Test;

import java.util.regex.Pattern;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/07/22.
 */
public class TestAll {

    String s = "om.jcraft.jsch.JSchException: Auth cancel\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:518)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:183)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:71)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Exception in thread \"host :192.168.1.201\" java.lang.NullPointerException\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:108)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "com.jcraft.jsch.JSchException: Auth cancel\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:518)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:183)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:71)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Exception in thread \"host :192.168.1.188\" java.lang.NullPointerException\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:108)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "10:49:44.844 [host :192.168.1.168] INFO javassh.ConnectSsh - 192.168.1.168\t 结束\n" +
            "10:49:44.844 [host :192.168.1.155] INFO javassh.ConnectSsh - 192.168.1.155\t 结束\n" +
            "10:49:44.844 [host :192.168.1.200] INFO javassh.ConnectSsh - 192.168.1.200\t 结束\n" +
            "10:49:44.869 [host :192.168.1.162] INFO javassh.ConnectSsh - 192.168.1.162\t 结束\n" +
            "10:49:44.872 [host :192.168.1.154] INFO javassh.ConnectSsh - 192.168.1.154\t 结束\n" +
            "10:49:44.874 [host :192.168.1.152] INFO javassh.ConnectSsh - 192.168.1.152\t 结束\n" +
            "10:49:44.986 [host :192.168.1.163] INFO javassh.ConnectSsh - 192.168.1.163\t 结束\n" +
            "10:49:44.987 [host :192.168.1.180] INFO javassh.ConnectSsh - 192.168.1.180\t 结束\n" +
            "10:49:44.995 [host :192.168.1.160] INFO javassh.ConnectSsh - 192.168.1.160\t 结束\n" +
            "10:49:45.004 [host :192.168.1.171] INFO javassh.ConnectSsh - 192.168.1.171\t 结束\n" +
            "10:49:45.032 [host :192.168.1.167] INFO javassh.ConnectSsh - 192.168.1.167\t 结束\n" +
            "10:49:45.037 [host :192.168.1.175] INFO javassh.ConnectSsh - 192.168.1.175\t 结束\n" +
            "10:49:45.039 [host :192.168.1.157] INFO javassh.ConnectSsh - 192.168.1.157\t 结束\n" +
            "10:49:45.047 [host :192.168.1.164] INFO javassh.ConnectSsh - 192.168.1.164\t 结束\n" +
            "10:49:45.048 [host :192.168.1.166] INFO javassh.ConnectSsh - 192.168.1.166\t 结束\n" +
            "10:49:45.066 [host :192.168.1.156] INFO javassh.ConnectSsh - 192.168.1.156\t 结束\n" +
            "10:49:45.070 [host :192.168.1.190] INFO javassh.ConnectSsh - 192.168.1.190\t 结束\n" +
            "10:49:45.071 [host :192.168.1.159] INFO javassh.ConnectSsh - 192.168.1.159\t 结束\n" +
            "10:49:45.092 [host :192.168.1.151] INFO javassh.ConnectSsh - 192.168.1.151\t 结束\n" +
            "10:49:45.103 [host :192.168.1.179] INFO javassh.ConnectSsh - 192.168.1.179\t 结束\n" +
            "10:49:45.113 [host :192.168.1.182] INFO javassh.ConnectSsh - 192.168.1.182\t 结束\n" +
            "10:49:45.115 [host :192.168.1.177] INFO javassh.ConnectSsh - 192.168.1.177\t 结束\n" +
            "10:49:45.154 [host :192.168.1.149] INFO javassh.ConnectSsh - 192.168.1.149\t 结束\n" +
            "10:49:45.182 [host :192.168.1.176] INFO javassh.ConnectSsh - 192.168.1.176\t 结束\n" +
            "10:49:45.225 [host :192.168.1.148] INFO javassh.ConnectSsh - 192.168.1.148\t 结束\n" +
            "10:49:45.283 [host :192.168.1.150] INFO javassh.ConnectSsh - 192.168.1.150\t 结束\n" +
            "com.jcraft.jsch.JSchException: Auth cancel\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:518)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:183)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:71)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Exception in thread \"host :192.168.1.199\" java.lang.NullPointerException\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:108)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "10:49:45.355 [host :192.168.1.161] INFO javassh.ConnectSsh - 192.168.1.161\t 结束\n" +
            "10:49:45.364 [host :192.168.1.173] INFO javassh.ConnectSsh - 192.168.1.173\t 结束\n" +
            "10:49:45.383 [host :192.168.1.158] INFO javassh.ConnectSsh - 192.168.1.158\t 结束\n" +
            "10:49:45.428 [host :192.168.1.181] INFO javassh.ConnectSsh - 192.168.1.181\t 结束\n" +
            "10:49:45.698 [host :192.168.1.183] INFO javassh.ConnectSsh - 192.168.1.183\t 结束\n" +
            "com.jcraft.jsch.JSchException: Auth cancel\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:518)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:183)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:71)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Exception in thread \"host :192.168.1.153\" java.lang.NullPointerException\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:108)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "10:49:47.825 [host :192.168.1.165] INFO javassh.ConnectSsh - 192.168.1.165\t 结束\n" +
            "com.jcraft.jsch.JSchException: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat com.jcraft.jsch.Util.createSocket(Util.java:394)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:215)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:183)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:71)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Caused by: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat java.net.DualStackPlainSocketImpl.connect0(Native Method)\n" +
            "\tat java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:79)\n" +
            "\tat java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)\n" +
            "\tat java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)\n" +
            "\tat java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)\n" +
            "\tat java.net.Socket.connect(Socket.java:589)\n" +
            "\tat java.net.Socket.connect(Socket.java:538)\n" +
            "\tat java.net.Socket.<init>(Socket.java:434)\n" +
            "\tat java.net.Socket.<init>(Socket.java:211)\n" +
            "\tat com.jcraft.jsch.Util$1.run(Util.java:362)\n" +
            "\t... 1 more\n" +
            "com.jcraft.jsch.JSchException: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat com.jcraft.jsch.Util.createSocket(Util.java:394)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:215)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:183)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:71)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Caused by: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat java.net.DualStackPlainSocketImpl.connect0(Native Method)\n" +
            "\tat java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:79)\n" +
            "\tat java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)\n" +
            "\tat java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)\n" +
            "\tat java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)\n" +
            "\tat java.net.Socket.connect(Socket.java:589)\n" +
            "\tat java.net.Socket.connect(Socket.java:538)\n" +
            "\tat java.net.Socket.<init>(Socket.java:434)\n" +
            "\tat java.net.Socket.<init>(Socket.java:211)\n" +
            "\tat com.jcraft.jsch.Util$1.run(Util.java:362)\n" +
            "\t... 1 more\n" +
            "Exception in thread \"host :192.168.1.174\" Exception in thread \"host :192.168.1.197\" java.lang.NullPointerException\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:108)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "java.lang.NullPointerException\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:108)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "com.jcraft.jsch.JSchException: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat com.jcraft.jsch.Util.createSocket(Util.java:394)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:215)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:183)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:71)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Caused by: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat java.net.DualStackPlainSocketImpl.connect0(Native Method)\n" +
            "\tat java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:79)\n" +
            "\tat java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)\n" +
            "\tat java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)\n" +
            "\tat java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)\n" +
            "\tat java.net.Socket.connect(Socket.java:589)\n" +
            "\tat java.net.Socket.connect(Socket.java:538)\n" +
            "\tat java.net.Socket.<init>(Socket.java:434)\n" +
            "\tat java.net.Socket.<init>(Socket.java:211)\n" +
            "\tat com.jcraft.jsch.Util$1.run(Util.java:362)\n" +
            "\t... 1 more\n" +
            "com.jcraft.jsch.JSchException: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat com.jcraft.jsch.Util.createSocket(Util.java:394)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:215)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:183)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:71)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Caused by: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat java.net.DualStackPlainSocketImpl.connect0(Native Method)\n" +
            "\tat java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:79)\n" +
            "\tat java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)\n" +
            "\tat java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)\n" +
            "\tat java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)\n" +
            "\tat java.net.Socket.connect(Socket.java:589)\n" +
            "\tat java.net.Socket.connect(Socket.java:538)\n" +
            "\tat java.net.Socket.<init>(Socket.java:434)\n" +
            "\tat java.net.Socket.<init>(Socket.java:211)\n" +
            "\tat com.jcraft.jsch.Util$1.run(Util.java:362)\n" +
            "\t... 1 more\n" +
            "com.jcraft.jsch.JSchException: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat com.jcraft.jsch.Util.createSocket(Util.java:394)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:215)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:183)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:71)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Caused by: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat java.net.DualStackPlainSocketImpl.connect0(Native Method)\n" +
            "\tat java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:79)\n" +
            "\tat java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)\n" +
            "\tat java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)\n" +
            "\tat java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)\n" +
            "\tat java.net.Socket.connect(Socket.java:589)\n" +
            "\tat java.net.Socket.connect(Socket.java:538)\n" +
            "\tat java.net.Socket.<init>(Socket.java:434)\n" +
            "\tat java.net.Socket.<init>(Socket.java:211)\n" +
            "\tat com.jcraft.jsch.Util$1.run(Util.java:362)\n" +
            "\t... 1 more\n" +
            "com.jcraft.jsch.JSchException: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat com.jcraft.jsch.Util.createSocket(Util.java:394)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:215)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:183)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:71)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Caused by: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat java.net.DualStackPlainSocketImpl.connect0(Native Method)\n" +
            "\tat java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:79)\n" +
            "\tat java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)\n" +
            "\tat java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)\n" +
            "\tat java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)\n" +
            "\tat java.net.Socket.connect(Socket.java:589)\n" +
            "\tat java.net.Socket.connect(Socket.java:538)\n" +
            "\tat java.net.Socket.<init>(Socket.java:434)\n" +
            "\tat java.net.Socket.<init>(Socket.java:211)\n" +
            "\tat com.jcraft.jsch.Util$1.run(Util.java:362)\n" +
            "\t... 1 more\n" +
            "Exception in thread \"host :192.168.1.196\" java.lang.NullPointerException\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:108)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Exception in thread \"host :192.168.1.193\" Exception in thread \"host :192.168.1.189\" Exception in thread \"host :192.168.1.178\" java.lang.NullPointerException\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:108)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "java.lang.NullPointerException\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:108)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "java.lang.NullPointerException\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:108)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "com.jcraft.jsch.JSchException: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat com.jcraft.jsch.Util.createSocket(Util.java:394)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:215)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:183)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:71)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Caused by: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat java.net.DualStackPlainSocketImpl.connect0(Native Method)\n" +
            "\tat java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:79)\n" +
            "\tat java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)\n" +
            "\tat java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)\n" +
            "\tat java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)\n" +
            "\tat java.net.Socket.connect(Socket.java:589)\n" +
            "\tat java.net.Socket.connect(Socket.java:538)\n" +
            "\tat java.net.Socket.<init>(Socket.java:434)\n" +
            "\tat java.net.Socket.<init>(Socket.java:211)\n" +
            "\tat com.jcraft.jsch.Util$1.run(Util.java:362)\n" +
            "\t... 1 more\n" +
            "com.jcraft.jsch.JSchException: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat com.jcraft.jsch.Util.createSocket(Util.java:394)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:215)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:183)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:71)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Caused by: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat java.net.DualStackPlainSocketImpl.connect0(Native Method)\n" +
            "\tat java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:79)\n" +
            "\tat java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)\n" +
            "\tat java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)\n" +
            "\tat java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)\n" +
            "\tat java.net.Socket.connect(Socket.java:589)\n" +
            "\tat java.net.Socket.connect(Socket.java:538)\n" +
            "\tat java.net.Socket.<init>(Socket.java:434)\n" +
            "\tat java.net.Socket.<init>(Socket.java:211)\n" +
            "\tat com.jcraft.jsch.Util$1.run(Util.java:362)\n" +
            "\t... 1 more\n" +
            "com.jcraft.jsch.JSchException: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat com.jcraft.jsch.Util.createSocket(Util.java:394)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:215)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:183)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:71)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Caused by: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat java.net.DualStackPlainSocketImpl.connect0(Native Method)\n" +
            "\tat java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:79)\n" +
            "\tat java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)\n" +
            "\tat java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)\n" +
            "\tat java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)\n" +
            "\tat java.net.Socket.connect(Socket.java:589)\n" +
            "\tat java.net.Socket.connect(Socket.java:538)\n" +
            "\tat java.net.Socket.<init>(Socket.java:434)\n" +
            "\tat java.net.Socket.<init>(Socket.java:211)\n" +
            "\tat com.jcraft.jsch.Util$1.run(Util.java:362)\n" +
            "\t... 1 more\n" +
            "com.jcraft.jsch.JSchException: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat com.jcraft.jsch.Util.createSocket(Util.java:394)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:215)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:183)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:71)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Caused by: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat java.net.DualStackPlainSocketImpl.connect0(Native Method)\n" +
            "\tat java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:79)\n" +
            "\tat java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)\n" +
            "\tat java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)\n" +
            "\tat java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)\n" +
            "\tat java.net.Socket.connect(Socket.java:589)\n" +
            "\tat java.net.Socket.connect(Socket.java:538)\n" +
            "\tat java.net.Socket.<init>(Socket.java:434)\n" +
            "\tat java.net.Socket.<init>(Socket.java:211)\n" +
            "\tat com.jcraft.jsch.Util$1.run(Util.java:362)\n" +
            "\t... 1 more\n" +
            "Exception in thread \"host :192.168.1.184\" Exception in thread \"host :192.168.1.192\" Exception in thread \"host :192.168.1.172\" Exception in thread \"host :192.168.1.187\" java.lang.NullPointerException\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:108)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "java.lang.NullPointerException\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:108)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "java.lang.NullPointerException\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:108)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "java.lang.NullPointerException\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:108)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "com.jcraft.jsch.JSchException: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat com.jcraft.jsch.Util.createSocket(Util.java:394)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:215)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:183)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:71)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Caused by: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat java.net.DualStackPlainSocketImpl.connect0(Native Method)\n" +
            "\tat java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:79)\n" +
            "\tat java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)\n" +
            "\tat java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)\n" +
            "\tat java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)\n" +
            "\tat java.net.Socket.connect(Socket.java:589)\n" +
            "\tat java.net.Socket.connect(Socket.java:538)\n" +
            "\tat java.net.Socket.<init>(Socket.java:434)\n" +
            "\tat java.net.Socket.<init>(Socket.java:211)\n" +
            "\tat com.jcraft.jsch.Util$1.run(Util.java:362)\n" +
            "\t... 1 more\n" +
            "com.jcraft.jsch.JSchException: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat com.jcraft.jsch.Util.createSocket(Util.java:394)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:215)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:183)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:71)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Caused by: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat java.net.DualStackPlainSocketImpl.connect0(Native Method)\n" +
            "\tat java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:79)\n" +
            "\tat java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)\n" +
            "\tat java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)\n" +
            "\tat java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)\n" +
            "\tat java.net.Socket.connect(Socket.java:589)\n" +
            "\tat java.net.Socket.connect(Socket.java:538)\n" +
            "\tat java.net.Socket.<init>(Socket.java:434)\n" +
            "\tat java.net.Socket.<init>(Socket.java:211)\n" +
            "\tat com.jcraft.jsch.Util$1.run(Util.java:362)\n" +
            "\t... 1 more\n" +
            "Exception in thread \"host :192.168.1.202\" java.lang.NullPointerException\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:108)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Exception in thread \"host :192.168.1.194\" java.lang.NullPointerException\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:108)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "com.jcraft.jsch.JSchException: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat com.jcraft.jsch.Util.createSocket(Util.java:394)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:215)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:183)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:71)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Caused by: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat java.net.DualStackPlainSocketImpl.connect0(Native Method)\n" +
            "\tat java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:79)\n" +
            "\tat java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)\n" +
            "\tat java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)\n" +
            "\tat java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)\n" +
            "\tat java.net.Socket.connect(Socket.java:589)\n" +
            "\tat java.net.Socket.connect(Socket.java:538)\n" +
            "\tat java.net.Socket.<init>(Socket.java:434)\n" +
            "\tat java.net.Socket.<init>(Socket.java:211)\n" +
            "\tat com.jcraft.jsch.Util$1.run(Util.java:362)\n" +
            "\t... 1 more\n" +
            "com.jcraft.jsch.JSchException: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat com.jcraft.jsch.Util.createSocket(Util.java:394)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:215)\n" +
            "\tat com.jcraft.jsch.Session.connect(Session.java:183)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:71)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "Caused by: java.net.ConnectException: Connection timed out: connect\n" +
            "\tat java.net.DualStackPlainSocketImpl.connect0(Native Method)\n" +
            "\tat java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:79)\n" +
            "\tat java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)\n" +
            "\tat java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)\n" +
            "\tat java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)\n" +
            "\tat java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)\n" +
            "\tat java.net.Socket.connect(Socket.java:589)\n" +
            "\tat java.net.Socket.connect(Socket.java:538)\n" +
            "\tat java.net.Socket.<init>(Socket.java:434)\n" +
            "\tat java.net.Socket.<init>(Socket.java:211)\n" +
            "\tat com.jcraft.jsch.Util$1.run(Util.java:362)\n" +
            "\t... 1 more\n" +
            "Exception in thread \"host :192.168.1.169\" Exception in thread \"host :192.168.1.191\" java.lang.NullPointerException\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:108)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "java.lang.NullPointerException\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:108)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "com.jcraft.jsch.JSchException: channel is not opened.\n" +
            "\tat com.jcraft.jsch.Channel.sendChannelOpen(Channel.java:765)\n" +
            "\tat com.jcraft.jsch.Channel.connect(Channel.java:151)\n" +
            "\tat com.jcraft.jsch.Channel.connect(Channel.java:145)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:73)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "10:50:02.616 [host :192.168.1.185] INFO javassh.ConnectSsh - 192.168.1.185\t 结束\n" +
            "com.jcraft.jsch.JSchException: channel is not opened.\n" +
            "\tat com.jcraft.jsch.Channel.sendChannelOpen(Channel.java:765)\n" +
            "\tat com.jcraft.jsch.Channel.connect(Channel.java:151)\n" +
            "\tat com.jcraft.jsch.Channel.connect(Channel.java:145)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:73)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "10:50:02.636 [host :192.168.1.170] INFO javassh.ConnectSsh - 192.168.1.170\t 结束\n" +
            "com.jcraft.jsch.JSchException: channel is not opened.\n" +
            "\tat com.jcraft.jsch.Channel.sendChannelOpen(Channel.java:765)\n" +
            "\tat com.jcraft.jsch.Channel.connect(Channel.java:151)\n" +
            "\tat com.jcraft.jsch.Channel.connect(Channel.java:145)\n" +
            "\tat javassh.ConnectSsh.upload(ConnectSsh.java:73)\n" +
            "\tat javassh.ConnectSsh.run(ConnectSsh.java:177)\n" +
            "\tat java.lang.Thread.run(Thread.java:745)\n" +
            "10:50:02.784 [host :192.168.1.186] INFO javassh.ConnectSsh - 192.168.1.186\t 结束\n" +
            "Disconnected from the target VM, address: '127.0.0.1:3122', transport: 'socket'\n";

    Pattern IPv4 = Pattern.compile("(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}");

    @Test
    public void test() {
//        String[] lines = s.split("\n");
//        List<String> ips = new ArrayList<String>();
//        for (String line : lines) {
//            if (line.contains("javassh.ConnectSsh")) {
//
//                Matcher mat = IPv4.matcher(line);
//                String ip = null;
//                if (mat.find()) {
//                    ip = mat.group();
//                    ips.add(ip);
//                    System.out.println("writeList.add(\"" + ip + "\");");
//                }
//            }
//        }
//        ips.sort((a, b) -> {
//            String[] aArr = a.split("\\.");
//            String[] bArr = b.split("\\.");
//            int res = 0;
//            for (int i = 0; i < aArr.length; i++) {
//                res = Integer.parseInt(aArr[i]) - Integer.parseInt(bArr[i]);
//                if (res != 0) {
//                    return res;
//                }
//            }
//            return res;
//        });
//        System.out.println(ips);
    }
}
