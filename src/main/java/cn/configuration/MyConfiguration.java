package cn.configuration;

import cn.io.FileUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @auther liuzhuochuan
 * @create 2022-03-29-19:32
 **/

@Configuration
@ComponentScan(basePackages = "cn")
public class MyConfiguration {


    @Bean
    public FileUtil fileUtil(){
        return new FileUtil(".");
    }

}
