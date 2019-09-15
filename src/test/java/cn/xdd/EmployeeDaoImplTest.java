package cn.xdd;

import cn.xdd.dao.impl.EmployeeDaoImpl;
import cn.xdd.po.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

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
    public void testFindAll() throws SQLException {
       employeeDao.findAll().forEach((e)-> System.out.println(e));
    }

    @Test
    public void testFindCount() throws SQLException {
        System.out.println(employeeDao.findCount());
    }

    @Test
    public void testPagingQuery() throws SQLException {
        List<Employee> list=employeeDao.pagingQuery(1L,3);
        list.forEach((e)-> System.out.println(e));
    }

    @Test
    public void testInsert() throws SQLException {
        Employee employee=new Employee();
        employee.setName("按时缴费卡十九分2222");
        long effect=employeeDao.insert(employee);
        System.out.println("影响："+effect);
    }
}
