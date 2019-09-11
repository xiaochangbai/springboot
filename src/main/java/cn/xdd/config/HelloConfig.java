package cn.xdd.config;

import cn.xdd.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xchb
 * @version 1.0
 * @ClassName HelloConfig
 * @description 使用@Configuration注解，表示这是个配置类
 * 日志级别由低到高依次是：trace<debug<info<warn<error
 * @createTime 2019年09月07日 22:56
 */

@Configuration
public class HelloConfig {

    //使用slf4j日志门面进行日志记录
    private Logger logger= LoggerFactory.getLogger(getClass());

    /**
     * 默认方法名就是组件id，返回值就是组件类
     * @return
     */
    @Bean
    public HelloService helloService() throws NoSuchMethodException {
        String returnType=this.getClass().getMethod("helloService",null).getReturnType().getSimpleName();
        logger.info(returnType+"，开始装配");
        HelloService helloService= new HelloService();
        logger.info(returnType+"加入容器成功。");
        return helloService;
    }
}
