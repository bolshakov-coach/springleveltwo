package pro.bolshakov.geekbrains.springleveltwo.lesson03.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pro.bolshakov.geekbrains.springleveltwo.lesson03.aop.service.PredefinedService;
import pro.bolshakov.geekbrains.springleveltwo.lesson03.aop.service.RndService;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        RndService rndService = context.getBean(RndService.class);
        System.out.println(rndService.getString());

        PredefinedService predefinedService = context.getBean(PredefinedService.class);
        System.out.println(predefinedService.getString());
    }
}