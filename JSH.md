1.新建jsch对象，作为基础句柄使用 

    JSch jsch = new JSch();
2.根据用户名，主机ip，端口号获取一个session，与远程服务器建立一个会话连接

    session = jsch.getSession(userName, host, port);
    session.setPassword(passWord); // 设置密码
    session.setUserInfo(new MyUserInfo()); //需要实现Jsch包中的UserInfo,UIKeyboardInteractive接口，用以保存用户信息，以及进行键盘交互式认证并执行命令。
    Properties config = new Properties();
    config.put("StrictHostKeyChecking", "no");//在代码里需要跳过检测。否则会报错找不到主机
    session.setConfig(config); // 为Session对象设置properties
    int timeout = 30000;
    session.setTimeout(timeout); // 设置timeout时间
    session.connect(); // 通过Session建立与远程服务器的连接回话
3.session建立之后，可以基于此，在远程服务器上执行shell以及文件上传下载操作了

   执行shell代码实现：
    
    ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
    channelExec.setCommand(cmd);         //添加传入进来的shell命令
    channelExec.setInputStream(null);
    channelExec.setErrStream(System.err);//通道连接错误信息提示
    channelExec.connect();
    logger.info("start execute channel command!");
    BufferedReader in = new BufferedReader(new InputStreamReader(channelExec.getInputStream()));
    String msg;
    logger.info("start read!");
    while ((msg = in.readLine()) != null) {
        logger.info("命令返回信息：{}", msg);
    }
    in.close();
    channelExec.disconnect();
    logger.info("end execute channel command!");
 文件下载代码实现：
    
    ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
    channelSftp.connect();
    logger.info("start download channel file!");
    channelSftp.cd(directory);
    File file = new File(saveDir);
    channelSftp.get(downloadFile, new FileOutputStream(file));
    logger.info("Download Success!");
    channelSftp.disconnect();
    logger.info("end execute channel sftp!");
 文件上传代码实现：

    ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
    channelSftp.connect();
    logger.info("start upload channel file!");
    channelSftp.cd(directory);
    channelSftp.put(file.getInputStream(), file.getOriginalFilename());
    logger.info("Upload Success!");
    channelSftp.disconnect();
    logger.info("end execute channel sftp!");   
————————————————
版权声明：本文为CSDN博主「zjw-java」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/kobelikec/article/details/87913592