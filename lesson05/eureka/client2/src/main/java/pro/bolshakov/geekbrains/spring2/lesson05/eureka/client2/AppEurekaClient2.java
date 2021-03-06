package pro.bolshakov.geekbrains.spring2.lesson05.eureka.client2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppEurekaClient2 {

    public static void main(String[] args) {
        SpringApplication.run(AppEurekaClient2.class, args);
    }

}
