package main.implementation.medium.binary;

public class SumOfTwoIntegers {
  public static void main(String[] args) {
    SumOfTwoIntegers s= new SumOfTwoIntegers();
    System.out.println(s.getSum(1, 2));
  }

  public int getSum(int a, int b) {
    while(b != 0) {
      int temp = (a & b) << 1;
      a = a ^ b;
      b = temp;
    }
    return a;
  }
}
