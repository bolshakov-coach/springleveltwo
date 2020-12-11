package pro.bolshakov.geekbrains.springleveltwo.lesson03.spel.example12;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;

public class ExampleRun {

    public static void main(String[] args) throws NoSuchMethodException {

        ExpressionParser parser = new SpelExpressionParser();
        Object value = parser.parseExpression("new pro.bolshakov.geekbrains." +
                "springleveltwo.lesson03.spel.example12.ExampleRun.User('Petr', 33)")
                .getValue();

        System.out.println(value);
    }

    public static class User{
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
