package cn.xdd.service.impl;

import cn.xdd.dao.IEmployeeDao;
import cn.xdd.po.Employee;
import cn.xdd.util.PagingShowUtil;
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

    /**
     * 分页查询操作
     * @param pageNum  页码
     * @param num   每页的数量
     * @return
     */
    @Override
    public PagingShowUtil<Employee> empPaging(Long pageNum, int num){
        PagingShowUtil<Employee> empPaging=new PagingShowUtil<Employee>();
        try{
            //数据总条数
            long totalCount=iEmployeeDao.findCount();
            //总的页数=总数据量/每页的数据量，向上取整
            long totalPages= (long) Math.ceil(totalCount*1.0/num);
            //当前查询的页在数据库中的位置=(当前页码-1)*每页的数据量
            long startNum=(pageNum-1)*num;
            System.out.println("页面编号："+pageNum+", 开始位置："+startNum);
            empPaging.setTotalDataCount(totalCount);
            empPaging.setTotalPageNum(totalPages);
            empPaging.setCurrentPageNum(pageNum);
            empPaging.setData(iEmployeeDao.pagingQuery(startNum,num));
            empPaging.setStatus(200);
            empPaging.setDescription("成功");
        }catch (SQLException e){
            empPaging.setStatus(500);
            empPaging.setDescription("失败【错误代码202】");
        }
        return empPaging;
    }


}
