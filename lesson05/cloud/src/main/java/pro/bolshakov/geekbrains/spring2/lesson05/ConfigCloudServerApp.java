package pro.bolshakov.geekbrains.spring2.lesson05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigCloudServerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCloudServerApp.class, args);
    }
}
