package cn.xdd.controller;

import cn.xdd.po.Person;
import cn.xdd.po.Pets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xchb
 * @version 1.0
 * @ClassName HelloController
 * @description null
 * @createTime 2019年09月07日 15:30
 */

@Controller
public class HelloController {
    private int requestNum=0;
    @Autowired
    private Person person;

    @RequestMapping("/hello")
    @ResponseBody
    public String test1(){
       return new Date()+"<br/>"+(requestNum++);
    }

    @RequestMapping("index")
    public String index(Map<String,Object> msg, HttpServletRequest request){
        msg.put("content","Hi，肖大大");
        msg.put("date",new Date());
        msg.put("list1",Arrays.asList("苹果","华为","小米","vivo","oppo"));
        msg.put("arrays",new int[]{1,4,15,5,16,19});
        msg.put("per",person);
        request.getSession();
        return "index";
    }

    @RequestMapping("/logining")
    public String logining(Model model){
        return "pages/login";
    }
}

/*


 */