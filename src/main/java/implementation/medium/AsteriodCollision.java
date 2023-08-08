package implementation.medium;

import java.util.Stack;

public class AsteriodCollision {
    public static void main(String[] args) {
        AsteriodCollision a = new AsteriodCollision();
        int[] ip = {10,2,-5};
        System.out.println(a.asteroidCollision(ip));

        for(Integer i : a.asteroidCollision(ip)) {
            System.out.print(i + "  ");
        }
    }

    public Integer[] asteroidCollision(int[] asteroids) {
        if(asteroids.length == 0) {
            return null;
        }

        Stack<Integer> theStack = new Stack<>();

        for(int a : asteroids) {
            while(!theStack.isEmpty() && a < 0 && theStack.peek() > 0) {
                int diff = a + theStack.peek();

                if(diff < 0) {
                    theStack.pop();
                } else if(diff > 0){
                    //theStack.push(asteroids[i]);
                    a =0;
                } else {
                    a =0;
                    theStack.pop();
                }
            }


            if (a > 0) {
                theStack.add(a);
            }
        }

        return theStack.toArray(new Integer[theStack.size()]);
    }
}
