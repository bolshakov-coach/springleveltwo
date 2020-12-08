package pro.bolshakov.geekbrains.springleveltwo.lesson03.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* pro.bolshakov.geekbrains.springleveltwo.lesson03.aop.service..*.*(..))")
    private void getString(){
    }

    @Before("getString()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println(joinPoint);
    }



}