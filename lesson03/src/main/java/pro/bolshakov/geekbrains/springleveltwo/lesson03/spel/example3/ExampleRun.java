package pro.bolshakov.geekbrains.springleveltwo.lesson03.spel.example3;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;

public class ExampleRun {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        SimpleContext simpleContext = new SimpleContext();
        simpleContext.values.add("Example");

        StandardEvaluationContext evaluationContext = new StandardEvaluationContext(simpleContext);

        parser.parseExpression("values[0]").setValue(evaluationContext, "newExample");
        parser.parseExpression("num").setValue(evaluationContext, 666);

        System.out.println(simpleContext.values.get(0));
        System.out.println(simpleContext.num);
    }


    public static class SimpleContext{
        public List<String> values = new ArrayList<>();
        public int num = 10;
    }

}
