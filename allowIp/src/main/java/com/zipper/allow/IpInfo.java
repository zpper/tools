package com.zipper.allow;

import java.util.Objects;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/15.
 */
public class IpInfo {

    private String title;
    private String ip;

    public IpInfo() {
    }

    public IpInfo(String[] subLines) {

        if (subLines != null && subLines.length == 2) {
            this.title = subLines[0];
            this.ip = subLines[1];
        } else if (subLines != null) {

            System.out.println("不支持的格式");
            for (int i = 0; i < subLines.length; i++) {
                System.out.println(subLines[i]);
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IpInfo ipInfo = (IpInfo) o;
        return Objects.equals(title, ipInfo.title) &&
                Objects.equals(ip, ipInfo.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, ip);
    }
}
