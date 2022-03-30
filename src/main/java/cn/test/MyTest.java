package cn.test;

import cn.configuration.MyConfiguration;
import cn.io.FileUtil;
import cn.io.RetrieveWriter;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @auther liuzhuochuan
 * @create 2022-03-29-19:35
 **/
public class MyTest {

    @Test
    public void test1() throws IOException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfiguration.class);

        RetrieveWriter bean = applicationContext.getBean(RetrieveWriter.class);

        bean.writerFile();
    }
}
