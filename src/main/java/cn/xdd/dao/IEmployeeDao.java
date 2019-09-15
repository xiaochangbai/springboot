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

    /**
     * 查询雇员的数量
     * @return
     * @throws SQLException
     */
    Long findCount()throws SQLException;


    /**
     * 分页查询
     * @param startNum  开始id
     * @param num   每页显示的个数
     * @return
     */
    List<Employee> pagingQuery(Long startNum,int num) throws SQLException;

    /**
     * 插入单个用户信息
     * @param employee
     * @return
     * @throws SQLException
     */
    Long insert(Employee employee) throws SQLException;
}
