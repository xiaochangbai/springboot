package cn.xdd.config;

import cn.xdd.component.MyLocaleResole;
import cn.xdd.intercept.OverallIntercept;
import cn.xdd.intercept.UserHandleIntercept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @author xchb
 * @version 1.0
 * @ClassName InterceptConfig
 * @description 自定义的springMvc配置
 * @createTime 2019年09月11日 19:40
 */

//@EnableWebMvc此注解表示，全全面接管springMVC，
//不使用springboot的所有springmvc配置，其中包含类路径下的static,public等等的文件映射

@Configuration
public class MyWebMVCConfig implements WebMvcConfigurer {

    /**
     * 添加全局拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(new UserHandleIntercept());
        addInterceptor.excludePathPatterns("/static/**");//不拦截静态资源
        addInterceptor.excludePathPatterns("/login.html");
        addInterceptor.excludePathPatterns("/login");
        addInterceptor.excludePathPatterns("/1");
        addInterceptor.excludePathPatterns("/");
        addInterceptor.addPathPatterns("/**");
    }


    /**
     * 添加视图控制器
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //请求/1路径时映射到index.html页面
        registry.addViewController("/1").setViewName("/index");
        registry.addViewController("/").setViewName("pages/login");
        registry.addViewController("/login.html").setViewName("pages/login");
        registry.addViewController("/main").setViewName("pages/dashboard.html");
    }


    /**
     * 向容器中添加自定义的区域信息解析器组件
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResole();
    }
}
