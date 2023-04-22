package section_01_lambda_expressions;
import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;


public class ConsumerDemo {
    
    public static void main(String[] args) {
        // Consumer<T> is a functional interface i.e. one abstract method:
        //      void accept(T t);
        Consumer<String> printC = s -> System.out.println(s);
        printC.accept("To be or not to be, that is the question.");

        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        names.forEach(printC);

        // BiConsumer<T,U> is a functional interface i.e. one abstract method:
        //       void accept(T t, U u);
        Map<String, String> mapCapitalCities = new HashMap<>();
        // Note: The return value of put(k,v) is just ignored (and not returned from the lambda).
        BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key, value);
        biCon.accept("Dublin", "Ireland");
        biCon.accept("Washington D.C.", "USA");
        System.out.println(mapCapitalCities);

        BiConsumer<String, String> mapPrint = (key,value) -> System.out.println(key + " is the capital of: " + value);
        mapCapitalCities.forEach(mapPrint);
    }
}
