package pro.bolshakov.geekbrains.springleveltwo.lesson03.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.bolshakov.geekbrains.springleveltwo.lesson03.aop.aspect.MeasureMethod;

@Service
public class PredefinedService {

    private PredefinedService selfLink;

    public PredefinedService() {
        System.out.println("Construction");
    }

    @Autowired
    public void setSelfLink(PredefinedService selfLink) {
        System.out.println("Set self link");
        this.selfLink = selfLink;
    }

    @MeasureMethod
    public String getString(){
        System.out.println("called PredefinedService.getString");
        return "SomeString";
    }

    public String getError(){
        System.out.println("called PredefinedService.getError");
        //AOP will not work in this case
        getString();

        if(1 == 1){
            throw new RuntimeException("Test");
        }
        return "";
    }

    public String getStringThroughSelfLink(){
        //some solution with self link
        System.out.println("called PredefinedService.getStringThroughSelfLink");
        return selfLink.getString();
    }
}
