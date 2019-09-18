package cn.xdd.service.impl;

import cn.xdd.dao.IEmployeeDao;
import cn.xdd.dao.impl.EmployeeDaoImpl;
import cn.xdd.po.Employee;
import cn.xdd.po.Person;
import cn.xdd.util.PagingShowUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
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

    /**
     * 插入用户数据
     * @param employee  需要插入的雇员对象
     * @return 插入成功返回true，反之返回false
     * @throws SQLException
     */
    @Override
    public boolean insert(Employee employee) throws SQLException {
        return iEmployeeDao.insert(employee)>1;
    }


    /**
     * 根据id删除用户
     * @param id 要删除用户的id
     * @return 删除成功返回true ，反之返回false
     * @throws SQLException  SQL语句执行异常
     */
    @Override
    public boolean deleteById(long id) throws SQLException {
        return iEmployeeDao.deleteById(id)>=1;
    }

    /**
     * 根据id查询雇员信息
     * @param id 雇员id
     * @return  返回查询出的雇员信息
     * @throws SQLException  SQL语句执行异常
     */
    @Override
    public Employee findById(long id) throws SQLException {
        return iEmployeeDao.findById(id);
    }

    @Override
    public boolean updateById(Employee employee) throws SQLException {
        if(employee.getName()==null || employee.getPasswd()==null ||
                employee.getGender()<0 || employee.getId()<0){
            return false;
        }
        return iEmployeeDao.updateById(employee)>0;
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext("cn.xdd.po");
        Person person= (Person) applicationContext.getBean("person");
        Employee employee= (Employee) applicationContext.getBean("employee");
        //输出
        System.out.println(person);
        System.out.println(employee);
        //获取bean定义
        BeanDefinition beanDefinition=applicationContext.getBeanDefinition("person");
        System.out.println(beanDefinition.getBeanClassName());
    }


}
