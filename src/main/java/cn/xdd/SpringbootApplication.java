package cn.xdd;

import cn.xdd.dao.impl.EmployeeDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.sql.SQLException;


@SpringBootApplication
/**
 * SpringBoot主程序员（后续添加的注解）
 * @author xchb
 * @version 1.0
 * @ClassName SpringbootApplication
 * @description null
 * @createTime 2019年09月16日 13:15
 * 其他注解：
 * @ImportResource(value = {"classpath:bean.xml"})  //导入其他配置
 */
public class SpringbootApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
