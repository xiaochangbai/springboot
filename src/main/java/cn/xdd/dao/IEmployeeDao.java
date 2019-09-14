package cn.xdd.dao;

import cn.xdd.po.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * @author xchb
 * @version 1.0
 * @ClassName IEmployeeDao
 * @description null
 * @createTime 2019年09月14日 15:27
 */
public interface IEmployeeDao {
    /**
     * 查询所有雇员信息
     * @return
     * @throws SQLException
     */
    List<Employee> findAll() throws SQLException;
}
