package cn.xdd.dao.impl;

import cn.xdd.po.Employee;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author xchb
 * @version 1.0
 * @ClassName EmployeeDaoImpl
 * @description null
 * @createTime 2019年09月14日 11:18
 */
@Repository
public class EmployeeDaoImpl implements cn.xdd.dao.IEmployeeDao {

    @Autowired
    @Qualifier("dbcpDataSource")
    private DataSource dataSource;

    @Override
    public List<Employee> findAll() throws SQLException {
        QueryRunner queryRunner=new QueryRunner(dataSource);
        List<Employee> list= queryRunner.query("select * from employee", new BeanListHandler<>(Employee.class));
        return list;
    }

    @Override
    public Long findCount() throws SQLException {
        QueryRunner queryRunner=new QueryRunner(dataSource);
        return (Long) queryRunner.query("select count(id) from employee", new ArrayHandler())[0];
    }

    @Override
    public List<Employee> pagingQuery(Long startNum, int num) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(dataSource);
        return queryRunner.query("select * from employee limit ?,?",new BeanListHandler<Employee>(Employee.class),startNum,num);
    }

    @Override
    public Long insert(Employee employee) throws SQLException {
        String name=employee.getName()==null? "A中孝" : employee.getName();
        String passwd=employee.getPasswd()==null? "123456" : employee.getPasswd();
        String phone=employee.getPhone()==null ? "15198970976" : employee.getPhone();
        String position=employee.getPosition()==null ? "湖南常德桃花源" : employee.getPosition();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        Object object=queryRunner.insert("insert into employee set name=?," +
                "passwd=?,gender=?,age=?,phone=?,position=?,dep_identifier=?",new ArrayHandler(),
                name,passwd,employee.getGender(),employee.getAge(),phone,position,employee.getDepIdentifier())[0];
        return Long.valueOf(object.toString());
    }

    @Override
    public int deleteById(long id) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(dataSource);
        return queryRunner.update("delete from employee where id=?",id);
    }

    @Override
    public Employee findById(long id) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(dataSource);
        return queryRunner.query("select * from employee where id=?",new BeanHandler<>(Employee.class),id);
    }

    @Override
    public long updateById(Employee employee) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(dataSource);
        return queryRunner.update("update employee set name=?,passwd=?,gender=? where id=?",
                employee.getName(),employee.getPasswd(),employee.getGender(),employee.getId());
    }


}
