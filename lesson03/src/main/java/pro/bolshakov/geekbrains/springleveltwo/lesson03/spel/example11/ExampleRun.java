package pro.bolshakov.geekbrains.springleveltwo.lesson03.spel.example11;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ExampleRun {

    public static void main(String[] args) throws NoSuchMethodException {

        ExpressionParser parser = new SpelExpressionParser();

        List<User> users = new ArrayList<>();
        users.add(new User("Petr", 25));
        users.add(new User("Ivan", 35));
        users.add(new User("Goga", 45));
        users.add(new User("Tom", 39));

        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable("users", users);

        {
            Object value = parser.parseExpression("#users.?[age>33]").getValue(evaluationContext);
            System.out.println(value.getClass() + " - " + value);
        }

        {
            Object value = parser.parseExpression("#users.^[age>33]").getValue(evaluationContext);
            System.out.println(value.getClass() + " - " + value);
        }
        {
            Object value = parser.parseExpression("#users.$[age>33]").getValue(evaluationContext);
            System.out.println(value.getClass() + " - " + value);
        }
        {
            Object value = parser.parseExpression("#users.![age]").getValue(evaluationContext);
            System.out.println(value.getClass() + " - " + value);
        }

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
