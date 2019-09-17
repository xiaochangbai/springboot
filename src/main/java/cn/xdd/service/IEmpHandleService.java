package cn.xdd.service;

import cn.xdd.po.Employee;
import cn.xdd.util.PagingShowUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * @author xchb
 * @version 1.0
 * @ClassName IEmpHandleService
 * @description null
 * @createTime 2019年09月14日 15:34
 */
public interface IEmpHandleService {
    /**
     * 查询所有雇员信息
     * @return  返回查询出雇员集合
     * @throws SQLException  SQL语句执行异常
     */
    List<Employee> findAllEmp() throws SQLException;

    /**
     * 雇员信息分页查询操作
     * @param pageNum  页码
     * @param num  每页的数量
     * @return  返回包装后的信息
     * @throws SQLException SQL语句执行异常
     */
    PagingShowUtil<Employee> empPaging(Long pageNum, int num) throws SQLException;

    /**
     *  插入用户
     * @param employee  需要插入的雇员对象
     * @return  插入成功返回true，否则返回false
     * @throws SQLException  SQL语句执行异常
     */
    boolean insert(Employee employee)throws SQLException;

    /**
     * 根据id删除用户
     * @param id 要删除用户的id
     * @return 删除成功返回true ，反之返回false
     * @throws SQLException  SQL语句执行异常
     */
    boolean deleteById(long id)throws SQLException;
}
