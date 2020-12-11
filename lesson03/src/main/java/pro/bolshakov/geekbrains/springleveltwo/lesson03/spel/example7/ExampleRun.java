package pro.bolshakov.geekbrains.springleveltwo.lesson03.spel.example7;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.ArrayList;
import java.util.List;

public class ExampleRun {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        List<String> expString = new ArrayList<>();
        expString.add("5 == 5");
        expString.add("2 > 2.5");
        expString.add("'koko' > 'koto'");
        expString.add("0 > null");
        expString.add("0 < null");
        expString.add("1 instanceof T(int)");
        expString.add("1 instanceof T(Integer)");
        expString.add("'127.0.0.1' matches '\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}\\b'");
        expString.add("'127.0.01' matches '\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}\\b'");

        for (String str : expString) {
            Expression expression = parser.parseExpression(str);
            System.out.println(str + " -> " + expression.getValue());
        }

    }
}
