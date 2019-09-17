package cn.xdd.dao;

import cn.xdd.dao.impl.EmployeeDaoImpl;
import cn.xdd.po.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * @author xchb
 * @version 1.0
 * @ClassName EmployeeDaoImplTest
 * @description EmployeeDaoImpl测试类
 * @createTime 2019年09月14日 12:18
 */
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

    @Test
    public void testDeleteById() throws SQLException{
        int effectLine=employeeDao.deleteById(118);
        System.out.println("影响行数："+effectLine);
    }
}
