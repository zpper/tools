package com.zipper.ssh;

import com.jcraft.jsch.UserInfo;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/01/27.
 */
public class MyUserInfo implements UserInfo {
    @Override
    public String getPassphrase() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean promptPassword(String s) {
        return false;
    }

    @Override
    public boolean promptPassphrase(String s) {
        return false;
    }

    @Override
    public boolean promptYesNo(String s) {
        return false;
    }

    @Override
    public void showMessage(String s) {

    }
}
