package section_01_lambda_expressions;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BoundMethodReferencesDemo {
    public static void main(String[] args) {
        String name = "Mr. Joe Bloggs";

        // Supplier<T>
        //  T get()
        Supplier<String> lowerL = () -> name.toLowerCase(); // lambda
        Supplier<String> lowerMR = name::toLowerCase;   // method reference

        // No need to say which instance to call it on - the supplier is bound to name
        System.out.println(lowerL.get()); // mr. joe bloggs
        System.out.println(lowerMR.get()); // mr. joe bloggs

        // Predicate<T>
        //      boolean test(T t)
        // Even though startsWith is overloaded, boolean startsWith(String) and
        // boolean startsWith(String, int), because we are creating the Predicate which
        // has a functional method of test(T t), the startsWith(String) is used.
        // This is where "context" is important.
        Predicate<String> titleL = (title) -> name.startsWith(title);
        Predicate<String> titleMR = name::startsWith;

        System.out.println(titleL.test("Mr.")); // true
        System.out.println(titleMR.test("Ms.")); // false
    }
}
