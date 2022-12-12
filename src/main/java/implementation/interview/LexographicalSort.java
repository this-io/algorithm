package implementation.interview;

import java.util.*;

public class LexographicalSort {
    public static void main(String[] args){
        sortAlgoTest(11111);
    }

    /*11111
    this will go till
     */

    public static List<Integer> sortAlgoTest(int n){
        int theNumberTillWhichSort = Integer.valueOf(n);
        //I assume that this always start with 1 and are positive integers.
        int firstNumber = 1;
        /*
        * As we know that the string comparison works in a certain way, I would like to
        * manipulate the way I am looping over the number till theNumber
        * */
        //1. Decide the range that Map would hold in key.
        List<String> stringifiedNumbers = new ArrayList<>();
        for(int i=1; i<=n; i++){
            stringifiedNumbers.add(String.valueOf(i));
        }
        Collections.sort(stringifiedNumbers);
        for(int i=0;i<stringifiedNumbers.size(); i++){
            System.out.println(stringifiedNumbers.get(i));
        }
        return null;
    }

    private static List<Integer> sort(int n){
        int first = 1;
        int last = n;


        return null;
    }
}
