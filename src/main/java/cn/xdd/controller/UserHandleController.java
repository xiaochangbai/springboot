package cn.xdd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Map;

/**
 * @author xchb
 * @version 1.0
 * @ClassName UserHandelController
 * @description null
 * @createTime 2019年09月13日 21:10
 */
@Controller
public class UserHandleController {

    @PostMapping("/login")
    public String login(String email, String password, Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(email) && !StringUtils.isEmpty(password)){
            //请求中存在邮箱号和密码
            if("704566072@qq.com".equals(email) && "123456".equals(password)){
                //邮箱和密码都正确
                session.setAttribute("loginUserEmail",email);
                //防止页面刷新，表单重复提交采用重定向方式跳转到控制台页
                return "redirect:/main";
            }else {
                //邮箱或密码错误
                map.put("msg","邮箱或密码错误");
            }
        }else {
            //请求中不存在邮箱号和密码
            map.put("msg","提交信息不存在");
        }
        //转发到登陆页面
        return "pages/login.html";
    }
}
