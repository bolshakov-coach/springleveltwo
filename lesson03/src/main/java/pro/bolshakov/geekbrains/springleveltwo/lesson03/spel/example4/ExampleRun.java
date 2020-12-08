package pro.bolshakov.geekbrains.springleveltwo.lesson03.spel.example4;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExampleRun {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("example4.xml");
        ValueHolder example1 = context.getBean("example1", ValueHolder.class);
        ValueHolder example2 = context.getBean("example2", ValueHolder.class);
        ValueHolder example3 = context.getBean("example3", ValueHolder.class);

        System.out.println(example1);
        System.out.println(example2);
        System.out.println(example3);

    }


}
