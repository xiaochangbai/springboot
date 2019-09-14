package cn.xdd.controller;

import cn.xdd.po.EmpPaging;
import cn.xdd.po.Employee;
import cn.xdd.service.IEmpHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        EmpPaging empPaging=iEmpHandleService.empPaging(id,6);
        modelMap.put("emps",empPaging);
        return "pages/customers";
    }


}
