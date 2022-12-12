package implementation.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
  public static void main(String[] args) {
    PascalTriangle pascalTriangle = new PascalTriangle();
    List<List<Integer>> result = pascalTriangle.generate(5);
    for (List<Integer> outer : result) {
      for (Integer i : outer) {
        System.out.print(i + "   ");
      }
      System.out.println();
    }
  }

  public List<List<Integer>> generate(int numRows) {
    if (numRows == 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> innerResult = new ArrayList<>();
    innerResult.add(1);
    result.add(innerResult);

    for (int i = 1; i < numRows; i++) {
      List<Integer> temp = result.get(i-1);
      temp.add(0);
      temp.add(0, 0);
      List<Integer> innerR = new ArrayList<>();
      for(int j=0; j < temp.size(); j++) {
        if(j+1 < temp.size()) {
          int innerAdd = temp.get(j) + temp.get(j + 1);
          innerR.add(innerAdd);
        }
      }
      temp.remove(0);
      temp.remove(temp.size() -1);
      result.add(innerR);
    }
    // 0  1  0
    return result;
  }
}
