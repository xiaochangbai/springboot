package cn.xdd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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

    @RequestMapping("/hello")
    @ResponseBody
    public String test1(){
       return new Date()+"<br/>"+(requestNum++);
    }
}
