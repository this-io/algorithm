package main.implementation.easy;

import java.lang.reflect.Array;

public class SumMultDifference {
  public static void main(String[] args) {
    SumMultDifference sumMultDifference = new SumMultDifference();
    System.out.println("===" + sumMultDifference.subtractProductAndSum(705));
  }

  public int subtractProductAndSum(int n) {
    int[] intArray = convertIntToArray(n);
    int sum = 0;
    int mult = 1;
    for (int i = 0; i < intArray.length; i++) {
      sum += intArray[i];
      mult *= intArray[i];
    }
    System.out.println("Mult : " + mult + "=====" + "Sum : " + sum);
    return mult - sum;
  }

  private int[] convertIntToArray(int n) {
    String temp = Integer.toString(n);
    int[] newGuess = new int[temp.length()];
    for (int i = 0; i < temp.length(); i++) {
      newGuess[i] = temp.charAt(i) - '0';
    }
    return newGuess;
  }
}
