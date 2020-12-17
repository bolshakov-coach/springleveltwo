package pro.bolshakov.geekbrains.spring2.lesson05.cloudrouter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class AppCloudRouter {

    public static void main(String[] args) {
        SpringApplication.run(AppCloudRouter.class, args);
    }
}
