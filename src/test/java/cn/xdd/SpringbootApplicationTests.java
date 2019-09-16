package cn.xdd;

import cn.xdd.po.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
/**
 *
 * @author xchb
 * @version 1.0
 * @ClassName SpringbootApplicationTests
 * @description SpringbootApplication测试类（后续添加的注解）
 * @createTime 2019年09月16日 13:55
 */
public class SpringbootApplicationTests {

    @Autowired
    private Person person;

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}
