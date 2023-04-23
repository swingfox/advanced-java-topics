package section_01;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryDemo {

    public static void main(String[] args) {
        // UnaryOperator<T> extends Function<T,T> is a functional interface i.e. one abstract method:
        //      T apply(T t)
        UnaryOperator<String> unaryOp = name -> "My name is " + name;
        System.out.println("UnaryOperator: " + unaryOp.apply("Sean"));


        // BinaryOperator<T> extends BiFunction<T,T> is a functional interface i.e. one abstract method:
        //      T apply(T t1, T t2)
        BinaryOperator<String> binaryOp = (s1, s2) -> s1.concat(s2);
        System.out.println("BinaryOperator: " + binaryOp.apply("William ", "Shakespeare"));
    }
    
}
