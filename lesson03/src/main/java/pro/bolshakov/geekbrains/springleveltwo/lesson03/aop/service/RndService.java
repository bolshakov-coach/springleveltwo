package pro.bolshakov.geekbrains.springleveltwo.lesson03.aop.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RndService {
    public String getString(){
        System.out.println("called RndService.getString");
        return UUID.randomUUID().toString();
    }
}