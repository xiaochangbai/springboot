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
     * @return
     * @throws SQLException
     */
    List<Employee> findAllEmp() throws SQLException;

    /**
     * 雇员信息分页查询操作
     * @param pageNum  页码
     * @param num   每页的数量
     * @return
     */
    PagingShowUtil<Employee> empPaging(Long pageNum, int num) throws SQLException;
}
