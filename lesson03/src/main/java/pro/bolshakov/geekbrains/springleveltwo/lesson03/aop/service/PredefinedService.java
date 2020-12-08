package pro.bolshakov.geekbrains.springleveltwo.lesson03.aop.service;

import org.springframework.stereotype.Service;

@Service
public class PredefinedService {

    public String getString(){
        return "SomeString";
    }

}
