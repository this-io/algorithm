package main.implementation.interview;

import java.util.ArrayList;
import java.util.List;

public class Amazon_FindMaxNumberOfProducts {
  public static void main(String[] args) {
    Amazon_FindMaxNumberOfProducts amazon_findMaxNumberOfProducts = new Amazon_FindMaxNumberOfProducts();
    List<Integer> input = new ArrayList<>();
    /*input.add(7);
    input.add(4);
    input.add(5);
    input.add(2);
    input.add(6);
    input.add(5);*/

    input.add(12);
    input.add(9);
    input.add(10);
    input.add(5);
    input.add(11);
    input.add(10);


    amazon_findMaxNumberOfProducts.findMaximumProducts(input);
  }


  public Long findMaximumProducts(List<Integer> products) {
    if (products == null || products.isEmpty()) {
      return 0L;
    }
    //input 12,9,10,5,11,10
    //deduction 2,3,4,5,9,10

    //input 7,4,5,2,6,5
    //deduction 1,1,1,2,4,5
    Long addToResult = 0L;
    for (int i = products.size() - 1; i >= 0; --i) {

      if (i == products.size() - 1) {
        addToResult = products.get(i) + 0L;
      } else {
        int left = products.get(i);
        int right = products.get(i+1);
        if (products.get(i) < products.get(i + 1)) {
          addToResult += products.get(i);
        } else if(products.get(i) > products.get(i+1) && (products.get(i+1) != 0)) {
          addToResult += products.get(i + 1) - 1;
          products.add(i, products.get(i + 1) - 1);
        }
      }
    }
    System.out.println(addToResult);
    return addToResult;
  }
}
