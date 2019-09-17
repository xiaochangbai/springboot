package cn.xdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;



/**
 * SpringBoot主程序类（后续添加的注解）
 * @author xchb
 * @version 1.0
 * @ClassName APP
 * @description null
 * @createTime 2019年09月16日 13:15
 * 其他注解：
 * @ImportResource(value = {"classpath:bean.xml"})  //导入其他配置
 */
@SpringBootApplication
public class APP {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(APP.class, args);
    }

}
