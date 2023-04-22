package section_01_lambda_expressions;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class StaticMethodReferenceDemo {
    public static void main(String[] args) {
        // Static method references are considered as UNBOUND also. An example static method
        // is Collections.sort(List)
        // Consumer<T>
        //     void accept(T t)
        //          void accept(List<Integer)
        // NB: Consumer takes one parameter => sort(List) is used, as opposed to sort(List, Comparator)
        Consumer<List<Integer>> sortL = list -> Collections.sort(list);
        Consumer<List<Integer>> sortMR = Collections::sort;

        List<Integer> listOfNumbers = Arrays.asList(2,1,5,4,9);
        sortL.accept(listOfNumbers); // execution
        System.out.println(listOfNumbers); // [1,2,4,5,9]

        listOfNumbers = Arrays.asList(8,12,4,3,7);
        sortMR.accept(listOfNumbers); // execution
        System.out.println(listOfNumbers); // [3,4,7,8,12]
    }
}
