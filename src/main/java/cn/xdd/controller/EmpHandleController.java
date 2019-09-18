package cn.xdd.controller;

import cn.xdd.po.Employee;
import cn.xdd.service.IEmpHandleService;
import cn.xdd.util.PagingShowUtil;
import com.mysql.cj.jdbc.admin.MiniAdmin;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    public String empInsert(Employee employee, @RequestParam("email") String email, HttpServletRequest request){
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


    /**
     * 根据id删除用户信息
     * @param id  要删除雇员的id
     * @return
     */
    @ResponseBody
    @DeleteMapping("/emp/{id}")
    public String empDelete(@PathVariable("id") long id){
        try {
            try {
                if(iEmpHandleService.deleteById(id)){
                    return "删除成功";
                }else {
                    return "删除失败，请检查后重试";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return "服务器异常";
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
            return "数据异常";
        }
    }


    /**
     * 根据id查出雇员信息（用作信息的回显），跳转到雇员信息修改页面
     * @param id
     * @param modelMap
     * @return
     */
    @PostMapping("/toUpdateEmpPage")
    public String toUpdateEmpPage(long id,ModelMap modelMap){
        Employee employee=null;
        try {
            employee=iEmpHandleService.findById(id);
            modelMap.put("emp_old",employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //转发到雇员信息修改页面
        return "pages/updateCustomers";
    }

    @PutMapping("/emp")
    public String empUpdate(Employee employee,ModelMap modelMap){
        try {
            boolean result=iEmpHandleService.updateById(employee);
            if(result){
                modelMap.put("status","修改成功");
            }else {
                modelMap.put("status","修改失败，错误代码201");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            modelMap.put("status","修改失败，错误代码202");
        }
        //转发回修改页面
        return "pages/updateCustomers";
    }





}
