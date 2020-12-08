package pro.bolshakov.geekbrains.springleveltwo.lesson03.spel.example9;

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
        simpleContext.values.add("aaa");
        simpleContext.values.add("bbb");
        simpleContext.values.add("ccc");
        simpleContext.values.add("ddd");
        simpleContext.values.add("eee");
        simpleContext.values.add("fff");

        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable("values", simpleContext.values);

        Object result = parser.parseExpression("#values.?[#this>'ccd']")
                .getValue(evaluationContext);

        System.out.println(result);
    }


    public static class SimpleContext{
        public List<String> values = new ArrayList<>();
    }

}
