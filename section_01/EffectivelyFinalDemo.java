package section_01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class EffectivelyFinalDemo {
    String name = "";

    public static void main(String[] args){
        ArrayList<String> al = new ArrayList<>();
        al.add("John");

        int x = 12; // final or effectively final
        // effective final means that the compiler will not let you change that local variable
        // once it is being used by the Predicate lambda.

        // Lambdas take a snapshot/picture of local variables; these local
        // variables MUST NOT change. Only setting up lambda here.
        Predicate<String> lambda = s -> {
           //x++;
            new EffectivelyFinalDemo().name = "Kennedy";
            // System.out.println("x == " + x);
            return s.isEmpty() && x % 2 == 0;
        };

        // If 'x' was allowed to change, then the method and the lambda would
        // have 2 different views of 'x'!
        // x++;
        filterData(al, lambda); // filter views 'x' as 12
        
    }

    public static void filterData(List<String> list, Predicate<String> lambda) {
        Iterator<String> i = list.iterator();
        while(i.hasNext()) {
            if (lambda.test(i.next())) {    // executing lambda here
                i.remove();
            }
        }
    }
}
