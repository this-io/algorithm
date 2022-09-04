package main.implementation.medium;

public class FindCelebrity_Sh {

  public static int findCelebrity(int n, int[][] arr) {

    int[] inDegree = new int[n]; // for every
    int[] outDegree = new int[n];

    for( int i = 0; i < n ; i++){
      for( int j = 0; j < n; j++) {
          if(arr[i][j] == 1) {
            // that means ith person knows jth person or not
            outDegree[i] += 1;
            inDegree[j] += 1;
          }
      }
    }

    for( int k = 0; k < inDegree.length; k++) {
      if(inDegree[k] == n - 1 && outDegree[k] == 0){
        return k;
      }
    }
    return -1;

  }


  public static void main(String[] args) {
    int[][] arr = {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0},{0, 0, 1, 0}};
    int res = findCelebrity(arr.length, arr);
    System.out.println(res);


  }
}
