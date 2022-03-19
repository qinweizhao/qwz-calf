package com.qinweizhao.system.config;

import com.qinweizhao.common.core.constant.CalfConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

/**
 * @author qinweizhao
 * @since 2021/9/25
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                //.allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置swagger静态资源映射
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        // static 映射
        registry.addResourceHandler("/static/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");

        // 文件上传
        String projectPath = System.getProperty("user.dir");;
        String path =CalfConstants.FILE_PROTOCOL +  projectPath + "/calf-resource/";
        System.out.println("FILE_path = " + path);
        registry.addResourceHandler("/**")
                .setCacheControl(CacheControl.maxAge(7L, TimeUnit.DAYS))
                .addResourceLocations(path)
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX);

        ;
    }

}
