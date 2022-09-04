package main.implementation.easy;

public class StringShuffler {
  public static void main(String[] args) {
    StringShuffler stringShuffler = new StringShuffler();
    String result = stringShuffler.restoreString("codeleet", new int[] {4,5,6,7,0,2,1,3});
    System.out.println("This is ==" + result);
  }

  public String restoreString(String s, int[] indices) {
    StringBuilder result = new StringBuilder(s);
    int counter =0;
    for(int i=0; i<indices.length; i++){
      result.setCharAt(indices[i], s.charAt(i));
    }
    return result.toString();
  }
}
