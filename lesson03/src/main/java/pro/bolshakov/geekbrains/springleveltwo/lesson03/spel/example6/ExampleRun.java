package pro.bolshakov.geekbrains.springleveltwo.lesson03.spel.example6;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Map;

public class ExampleRun {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        {
            Expression expression = parser.parseExpression("{1,2,3,4}");
            Object value = expression.getValue();
            System.out.println(value.getClass() + " - " + value);
        }
        {
            Expression expression = parser.parseExpression("{name:'Petr', date:'13-03-1990'}");
            Object value = expression.getValue();
            System.out.println(value.getClass() + " - " + value);
        }

        {
            Expression expression = parser.parseExpression("{name:{first:'Petr', last:'Ivanov'}, date:'13-03-1990'}");
            Map value = expression.getValue(Map.class);
            System.out.println(value.getClass() + " - " + value);
            System.out.println(value.get("name").getClass() + " - " + value.get("name"));
        }


    }
}
