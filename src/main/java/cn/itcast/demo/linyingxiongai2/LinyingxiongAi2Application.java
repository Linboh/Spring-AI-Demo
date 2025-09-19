package cn.itcast.demo.linyingxiongai2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.itcast.demo.linyingxiongai2.mapper")
@SpringBootApplication
public class LinyingxiongAi2Application {

    public static void main(String[] args) {
        SpringApplication.run(LinyingxiongAi2Application.class, args);
    }

}
