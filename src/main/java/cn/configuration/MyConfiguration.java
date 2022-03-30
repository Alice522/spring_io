package cn.configuration;

import cn.io.FileUtil;
import cn.io.RetrieveWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @auther liuzhuochuan
 * @create 2022-03-29-19:32
 **/

@Configuration
@ComponentScan(basePackages = "cn")
public class MyConfiguration {

    @Bean
    public RetrieveWriter retrieveWriter() throws IOException {
        return new RetrieveWriter(fileUtil(),fileWriter());
    }

    @Bean
    public FileWriter fileWriter() throws IOException {
        return new FileWriter("result1.txt");
    }

    @Bean
    public FileUtil fileUtil(){
        return new FileUtil(".");
    }

}
