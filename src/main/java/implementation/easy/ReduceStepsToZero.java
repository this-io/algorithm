package implementation.easy;

public class ReduceStepsToZero {
  public static void main(String[] args) {
    ReduceStepsToZero reduceStepsToZero = new ReduceStepsToZero();
    int count = reduceStepsToZero.numberOfSteps(14);
    System.out.println("=====" + count);
  }

  public int numberOfSteps(int num) {
    int counter = 0;
    while (num != 0) {
      if (num % 2 == 0) {
        num = num / 2;
      } else {
          num = num - 1;
      }
      counter++;
    }
    return counter;
  }
}
