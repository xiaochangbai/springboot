package cn.xdd.service.impl;

import cn.xdd.dao.IEmployeeDao;
import cn.xdd.po.EmpPaging;
import cn.xdd.po.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * @author xchb
 * @version 1.0
 * @ClassName EmpHandleService
 * @description null
 * @createTime 2019年09月14日 15:25
 */

@Service
public class EmpHandleServiceImpl implements cn.xdd.service.IEmpHandleService {

    @Autowired
    private IEmployeeDao iEmployeeDao;

    @Override
    public List<Employee> findAllEmp() throws SQLException {
        return iEmployeeDao.findAll();
    }

    @Override
    public EmpPaging empPaging(Long startNum, int num){
        EmpPaging empPaging=new EmpPaging();
        try{
            empPaging.setTotalPageNum(iEmployeeDao.findCount());
            empPaging.setCurrentPageNum(startNum);
            empPaging.addData(iEmployeeDao.findAll());
            empPaging.setStatus(200);
            empPaging.setDescription("成功");
        }catch (SQLException e){
            empPaging.setStatus(500);
            empPaging.setDescription("失败【错误代码202】");
        }
        return empPaging;
    }


}
