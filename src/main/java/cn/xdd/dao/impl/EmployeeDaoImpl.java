package cn.xdd.dao.impl;

import cn.xdd.po.Employee;
import org.apache.commons.dbutils.QueryRunner;
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
    private QueryRunner queryRunner;

    @Override
    public List<Employee> findAll() throws SQLException {
        queryRunner=new QueryRunner(dataSource);
        List<Employee> list=queryRunner.query("select * from employee",new BeanListHandler<Employee>(Employee.class));
        return list;
    }

}
