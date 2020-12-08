package pro.bolshakov.geekbrains.springleveltwo.lesson03.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* pro.bolshakov.geekbrains.springleveltwo.lesson03.aop.service..*.*(..))")
    private void anyMethod(){
    }

    @Before("anyMethod()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Log before ->" + joinPoint);
    }

    @After("anyMethod()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("Log after ->" + joinPoint);
    }

    @AfterReturning("anyMethod()")
    public void logReturning(JoinPoint joinPoint){
        System.out.println("Log AfterReturning ->" + joinPoint);
    }

    @AfterThrowing("anyMethod()")
    public void logTrowing(JoinPoint joinPoint){
        System.out.println("Log AfterThrowing ->" + joinPoint);
    }

    @Around("anyMethod()")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Log Around before -> " + System.currentTimeMillis());
        Object value = pjp.proceed();
        System.out.println("Log Around after ->" + System.currentTimeMillis());
        return value;
    }


}