// Component
interface Expression {
    double evaluate();
    void display();
}

class Number implements Expression {
    private double value;

    public Number(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public void display() {
        System.out.print(value);
    }
}

class ArithmeticExpression implements Expression {
    private Expression left;
    private Expression right;
    private char operator;

    public ArithmeticExpression(Expression left, Expression right, char operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public double evaluate() {
        switch (operator) {
            case '+':
                return left.evaluate() + right.evaluate();
            case '-':
                return left.evaluate() - right.evaluate();
            case '*':
                return left.evaluate() * right.evaluate();
            case '/':
                return left.evaluate() / right.evaluate();
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    @Override
    public void display() {
        System.out.print("(");
        left.display();
        System.out.print(" " + operator + " ");
        right.display();
        System.out.print(")");
    }
}

public class Composite_Pattern {
    public static void main(String [] args) {
        Expression num1 = new Number(4);
        Expression num2 = new Number(6);
        Expression num3 = new Number(5);

        Expression addition = new ArithmeticExpression(num1,num2,'+');//(4+6)
        Expression multiplication = new ArithmeticExpression(num3,addition,'*');//(4+6)*5
        Expression subtraction = new ArithmeticExpression(multiplication,num3,'-');
        Expression division = new ArithmeticExpression(subtraction,num3,'/');

        division.display();
        System.out.println();
        System.out.println(division.evaluate());


    }
}
