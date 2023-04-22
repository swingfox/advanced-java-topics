package section_01_lambda_expressions;
import java.util.function.BiFunction;
import java.util.function.Function;

public class UnboundMethodReferencesDemo {
    public static void main(String[] args){
        // Function<T,R>
        //  R apply(T)
        //      String apply(String)
        Function<String, String> upperL = s -> s.toUpperCase();
        Function<String, String> upperMR = String::toUpperCase;

        // The function is unboound, so you need to specify which instance to call it on.
        System.out.println(upperL.apply("sean"));   // SEAN
        System.out.println(upperMR.apply("sean"));  // SEAN

        // Function<T,U,R>
        //      R   apply(T t, U u)
        //          String apply(String, String)
        BiFunction<String, String, String> concatL = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> concatMR = String::concat;

        System.out.println(concatL.apply("Sean", "Kennedy")); // Sean Kennedy

        // 1st parameter is used for executing the instance method
        // "Sean".concat("Kennedy")
        System.out.println(concatMR.apply("Sean ", "Kennedy")); // Sean Kennedy
    }    
}
