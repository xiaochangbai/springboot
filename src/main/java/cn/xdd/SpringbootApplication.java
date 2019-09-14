package cn.xdd;

import cn.xdd.dao.impl.EmployeeDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.sql.SQLException;

//@ImportResource(value = {"classpath:bean.xml"})
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(SpringbootApplication.class, args);
        new EmployeeDaoImpl().findAll();
    }

}
