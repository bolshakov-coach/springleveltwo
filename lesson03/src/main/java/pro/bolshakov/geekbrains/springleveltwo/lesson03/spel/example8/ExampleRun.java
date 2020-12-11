package pro.bolshakov.geekbrains.springleveltwo.lesson03.spel.example8;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ExampleRun {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        SimpleContext simpleContext = new SimpleContext();
        simpleContext.values.add("Example");

        StandardEvaluationContext evaluationContext = new StandardEvaluationContext(simpleContext);

        evaluationContext.setVariable("newValue", UUID.randomUUID().toString());

        parser.parseExpression("values[0] = #newValue").getValue(evaluationContext);

        System.out.println(simpleContext.values.get(0));
    }


    public static class SimpleContext{
        public List<String> values = new ArrayList<>();
        public int num = 10;
    }

}
