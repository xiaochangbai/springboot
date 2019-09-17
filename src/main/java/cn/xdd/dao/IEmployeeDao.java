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
     * @return  返回一个雇员集合
     * @throws SQLException  SQL语句执行异常
     */
    List<Employee> findAll() throws SQLException;

    /**
     * 查询雇员的数量
     * @return  返回查询出的雇员数量
     * @throws SQLException  SQL语句执行异常
     */
    Long findCount()throws SQLException;


    /**
     * 分页查询
     * @param startNum  开始位置
     * @param num  每页显示的个数
     * @return  返回一个雇员集合
     * @throws SQLException SQL语句执行异常
     */
    List<Employee> pagingQuery(Long startNum,int num) throws SQLException;

    /**
     * 插入单个用户信息
     * @param employee  要插入的雇员对象
     * @return  返回当前插入信息的id
     * @throws SQLException SQL语句执行异常
     */
    Long insert(Employee employee) throws SQLException;

    /**
     * 根据id删除用户
     * @param id  要删除用户的id
     * @return   返回影响行数
     * @throws SQLException  SQL语句执行异常
     */
    int deleteById(long id)throws SQLException;
}
