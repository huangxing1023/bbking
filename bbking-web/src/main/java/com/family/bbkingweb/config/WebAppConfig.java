package com.family.bbkingweb.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

//上传配置类
//图片放到/F:/fileUpload/后，从磁盘读取的图片数据scr将会变成images/picturename.jpg的格式
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Value("${cbs.imagesPath}")
    private String imagesPath;//图片地址
    @Value("${cbs.viedosPath}")
    private String viedoPath;
    @Value("${cbs.audioPath}")
    private String audioPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/images/**").addResourceLocations(imagesPath).addResourceLocations(viedoPath).addResourceLocations(audioPath);
    }
}
