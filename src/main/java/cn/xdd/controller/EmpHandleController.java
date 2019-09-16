package cn.xdd.controller;

import cn.xdd.po.Employee;
import cn.xdd.service.IEmpHandleService;
import cn.xdd.util.PagingShowUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * 雇员控制器
 * @author xchb
 * @version 1.0
 * @ClassName EmpHandleController
 * @description restFul风格的请求
 * @createTime 2019年09月14日 15:21
 */
@Controller
public class EmpHandleController {

    @Autowired
    private IEmpHandleService iEmpHandleService;

    /**
     * 分页查询显示
     * @param modelMap
     * @param id
     * @return  转发到雇员信息展示页面
     * @throws SQLException
     */
    @GetMapping(value = "/emps/{id}")
    public String emps(ModelMap modelMap, @PathVariable(value = "id")long id) throws SQLException {
        if(id<=0){
            //参数错误，返回控制台页面
            return "pages/dashboard";
        }
        //MySQL分页查询，是从0位开始的。
        PagingShowUtil<Employee> empPaging=iEmpHandleService.empPaging(id,6);
        modelMap.put("emps",empPaging);
        return "pages/customers";
    }

    /**
     * 插入用户数据
     * @param employee
     * @param email
     * @param request
     * @return  转发到雇员信息添加页面
     */
    @PostMapping("/emp")
    public String emp(Employee employee, @RequestParam("email") String email, HttpServletRequest request){
        employee.setPosition(email);
        try {
            if(iEmpHandleService.insert(employee)){
                request.setAttribute("status","添加成功");
            }else {
                request.setAttribute("status","添加失败，请重试【201】");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("status","添加失败，请稍后重试【202】");
        }
        return "pages/addCustomers";
    }


}
