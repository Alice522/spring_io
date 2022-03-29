package cn.test;

import cn.configuration.MyConfiguration;
import cn.io.FileUtil;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther liuzhuochuan
 * @create 2022-03-29-19:35
 **/
public class MyTest {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfiguration.class);

        FileUtil bean = applicationContext.getBean(FileUtil.class);

        bean.retrieve();
    }
}
