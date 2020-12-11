package pro.bolshakov.geekbrains.springleveltwo.lesson03.spel.example2;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExampleRun {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        User user = new User("Vasiliy");
        Object value = parser.parseExpression("name").getValue(user);
        System.out.println(value);
    }

}
