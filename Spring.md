- [ ] <h5>
      Spring2.5（推荐使用xml配置） ---->  Spring3.0(推荐使用JavaCode Config) ----> 引入Import标签，导入配置。
  </h5>
  <ul>
      <li>BeanDefinition(bean定义)：包含bean的描述信息和操作</li>
      <li>AnnotationConfigApplicationContext</li>
  </ul>
  <ul>
      <li>@Configuration：当前类是配置类</li>
      <li>@Bean: 将当前方法返回的Bean添加到容器中，默认方法名做id</li>
      <li>@Import(Class'<'?'>' class):
      	<ul>
          	<li>普通的类：直接添加到容器中</li>
          	<li>实现ImportSelector接口的类：将selectImports方法返回的数组全都添加到容器中。			    </li>
          	<li>实现xxx接口。</li>
          </ul>
      </li>
  </ul> 

public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext("cn.xdd.po");
        Person person= (Person) applicationContext.getBean("person");
        Employee employee= (Employee) applicationContext.getBean("employee");
        //输出
        System.out.println(person);
        System.out.println(employee);
        //获取bean定义
        BeanDefinition beanDefinition=applicationContext.getBeanDefinition("person");
        System.out.println(beanDefinition.getBeanClassName());
    }

