package main.implementation.easy.binary;

public class NumberOf1Bits {
  public static void main(String[] args) {
    NumberOf1Bits n = new NumberOf1Bits();
    //byte n = 11111111111111111111111111111101;
    System.out.println(n.hammingWeight(00000000000000000000000000001011));
  }

  public int hammingWeight(int n) {
    int result = 0;
    while (n != 0) {
      n = n & (n - 1);
      result++;
    }
    return result;
  }
}
