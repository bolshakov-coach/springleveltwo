package pro.bolshakov.geekbrains.spring2.lesson05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppEurekaClientAsk {
    public static void main(String[] args) {
        SpringApplication.run(AppEurekaClientAsk.class, args);
    }
}
