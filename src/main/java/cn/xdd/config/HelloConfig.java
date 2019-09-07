package cn.xdd.config;

import cn.xdd.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xchb
 * @version 1.0
 * @ClassName HelloConfig
 * @description 使用@Configuration注解，表示这是个配置类
 * @createTime 2019年09月07日 22:56
 */

@Configuration
public class HelloConfig {

    /**
     * 默认方法名就是组件id，返回值就是组件类
     * @return
     */
    @Bean
    public Object helloService(){
        return new HelloService();
    }
}
