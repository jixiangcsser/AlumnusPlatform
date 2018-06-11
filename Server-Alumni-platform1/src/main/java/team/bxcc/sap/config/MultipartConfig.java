package team.bxcc.sap.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;


/**
 * 前段传给后台图片时对大小的配置
 *
 * @author JiXiang
 * @date 2018/6/9.
 */
@Configuration
public class MultipartConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(30*1024L * 1024L);
        return factory.createMultipartConfig();
    }
}