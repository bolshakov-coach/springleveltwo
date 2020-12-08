package pro.bolshakov.geekbrains.springleveltwo.lesson03.aop.service;

import org.springframework.stereotype.Service;

@Service
public class PredefinedService {

    public String getString(){
        System.out.println("called PredefinedService.getString");
        return "SomeString";
    }

    public String getError(){
        System.out.println("called PredefinedService.getError");
        if(1 == 1){
            throw new RuntimeException("Test");
        }
        return "";
    }

}
