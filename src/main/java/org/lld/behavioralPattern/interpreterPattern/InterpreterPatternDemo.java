package org.lld.behavioralPattern.interpreterPattern;
interface Expression{
    boolean interpret(String context);
}
class TerminalExpression implements Expression{
    String data;
    public TerminalExpression(String data){
        this.data = data;
    }
    @Override
    public boolean interpret(String context){
        return context.contains(data);
    }
}

class orExpression implements Expression{
    private Expression exp1;
    private Expression exp2;
    public orExpression(Expression exp1,Expression exp2){
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
    @Override
    public boolean interpret(String context){
        return exp1.interpret(context) || exp2.interpret(context);
    }
}

class andExpression implements Expression{
    private Expression exp1;
    private Expression exp2;
    public andExpression(Expression exp1,Expression exp2){
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
    @Override
    public boolean interpret(String context){
        return exp1.interpret(context) && exp2.interpret(context);
    }
}
public class InterpreterPatternDemo {
    private static Expression getMaleExpression(){
        Expression exp1 = new TerminalExpression("John");
        Expression exp2 = new TerminalExpression("Mike");
        return new orExpression(exp1,exp2);
    }
    private static Expression getMarriedWomen(){
        Expression exp1 = new TerminalExpression("Julie");
        Expression exp2 = new TerminalExpression("married");
        return new andExpression(exp1,exp2);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWomen = getMarriedWomen();

        System.out.println("John is a male? " + isMale.interpret("John is a male?"));
        System.out.println("Julie is a married woman? " + isMarriedWomen.interpret("Julie is a married woman?"));
        System.out.println("Mike is male? " + isMale.interpret("Mike is male?"));
        System.out.println("Julie alone? " + isMarriedWomen.interpret("Julie alone?"));
    }
}
