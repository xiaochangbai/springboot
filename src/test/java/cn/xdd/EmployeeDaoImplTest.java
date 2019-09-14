package cn.xdd;

import cn.xdd.dao.impl.EmployeeDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.sql.SQLOutput;

/**
 * @author xchb
 * @version 1.0
 * @ClassName EmployeeDaoImplTest
 * @description null
 * @createTime 2019年09月14日 12:18
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDaoImplTest {

    @Autowired
    private EmployeeDaoImpl employeeDao;

    @Test
    public void test1() throws SQLException {
       employeeDao.findAll().forEach((e)-> System.out.println(e));
    }
}
