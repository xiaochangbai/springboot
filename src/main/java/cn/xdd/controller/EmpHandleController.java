package cn.xdd.controller;

import cn.xdd.po.Employee;
import cn.xdd.service.IEmpHandleService;
import cn.xdd.util.PagingShowUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;

/**
 * @author xchb
 * @version 1.0
 * @ClassName EmpHandleController
 * @description null
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
     * @return
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
        System.out.println(empPaging);
        modelMap.put("emps",empPaging);
        return "pages/customers";
    }


}
