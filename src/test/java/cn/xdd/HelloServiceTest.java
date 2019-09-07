package cn.xdd;

import cn.xdd.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xchb
 * @version 1.0
 * @ClassName HelloServiceTest
 * @description null
 * @createTime 2019年09月07日 22:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    public void test1(){
        System.out.println(helloService);
    }


}
