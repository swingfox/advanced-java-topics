package section_01;

import java.util.function.*;

public class PredicateDemo {

    public static void main(String[] args) {
        Predicate<String> pStr = s -> s.contains("City");

        System.out.println(pStr.test("Vatican City"));

        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println(checkLength.test("Vatican City", 11));
    }
    
}