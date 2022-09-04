package main.implementation.medium;

public class DivideTwoInteger {
//To slow !!!!!
    public static void main(String[] args) {
        DivideTwoInteger dd = new DivideTwoInteger();
        int result = 0;
        /*result = dd.doTheNeedFul(3, 10);
        System.out.println("Result: "+ result);

        /*result = dd.doTheNeedFul(-3, 7);
        System.out.println("Result: "+ result);

        result = dd.doTheNeedFul(1, 1);
        System.out.println("Result: "+ result);

        result = dd.doTheNeedFul(1, 0);
        System.out.println("Result: "+ result);*/

        result = dd.doTheNeedFul(-1, -2147483648);
        System.out.println("Result: "+ result);

        result = dd.doTheNeedFul(1, -1);
        System.out.println("Result: "+ result);
    }

    private int doTheNeedFul(int divisor, int dividend) throws ArithmeticException {
        if(divisor == 0) {
            throw(new ArithmeticException("Divisor cannot be 0"));
        }
        int MAX_INT = Integer.MAX_VALUE;
        int MIN_INT = Integer.MIN_VALUE;
        int finalSign = 1;
        if(divisor < 0 || dividend < 0) {
            finalSign = -1;
            if(dividend < 0 && divisor < 0) {
                //System.out.println("This ==both===");
                finalSign = 1;
            }
            if(divisor < 0) {
                divisor = -1 * divisor;
            }
            if(dividend < 0) {
                //System.out.println("This is sktitit "+ dividend);
                if(dividend <= MIN_INT) {
                    //-1 <= -2147483648
                    dividend = MAX_INT;
                } else {
                    dividend = -1 * dividend;
                }
            }
        }

        if(dividend == divisor) {
            return 1*finalSign;
        }
        System.out.println("This is dividend ====="+ dividend);
        System.out.println("This is divisor ====="+ divisor);
        int counter = 0;
        while (dividend >= divisor) {
            dividend = dividend - divisor;
            counter++;

        }
        return counter*finalSign;
    }
}
