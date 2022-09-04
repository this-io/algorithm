package main.implementation.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
  public static void main(String[] args) {
    PascalTriangleII pascalTriangleII = new PascalTriangleII();
    List<Integer> result = pascalTriangleII.getRow(2);
    for(Integer i : result) {
      System.out.print(i + "  ");
    }
  }

  public List<Integer> getRow(int rowIndex) {
    if(rowIndex < 0 ) {
      return new ArrayList<>();
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> innerResult = new ArrayList<>();
    innerResult.add(1);
    result.add(innerResult);

    for (int i = 1; i < rowIndex+1; i++) {
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

    return result.get(result.size() - 1);
  }
}
