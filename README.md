#####javaFx 可以不使用显示声明主方法
启动类包括
* onswich.Second
* nodeExample.ColorfulCircles
* nodeExample.Xylophone
* fxmlexample.FXMLExample




#####编辑图片
######图片修改-demo:/doc/github.com_coobird_thumbnailator_wiki_Examples.png
    try {
    
        Thumbnails.of(new File("C:\\Users\\12925\\Pictures\\creet\\微信图片_20190310144130.jpg"))
                .size(160, 160)
                .toFile(new File("C:\\Users\\12925\\Pictures\\creet\\test.jpg"));
    } catch (IOException e) {
        e.printStackTrace();
    }
            
            
####图像识别ocr
    tess4j
    
    
    
#### 待观测

    <plugin>
        <groupId>com.zenjava</groupId>
        <artifactId>javafx-maven-plugin</artifactId>
        <version>8.8.3</version>
        <configuration>
            <vendor>zipper</vendor>
            <mainClass>webEngine.webEngine</mainClass>
        </configuration>
    </plugin>
    
    貌似将main函数放入jfx的启动函数中才行。待测试