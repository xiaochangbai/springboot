package cn.xdd.config;

import cn.xdd.intercept.OverallIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xchb
 * @version 1.0
 * @ClassName InterceptConfig
 * @description null
 * @createTime 2019年09月11日 19:40
 */

@Configuration
public class InterceptConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new OverallIntercept()).addPathPatterns("/*");
    }
}
