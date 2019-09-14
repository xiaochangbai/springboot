package cn.xdd.controller;

import cn.xdd.po.Employee;
import cn.xdd.service.IEmpHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.List;

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

    @GetMapping("/emps")
    public String emps(ModelMap modelMap) throws SQLException {
        List<Employee> list=iEmpHandleService.findAllEmp();
        modelMap.put("emps",list);
        return "pages/customers";
    }
}
