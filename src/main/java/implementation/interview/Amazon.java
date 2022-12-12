package implementation.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Amazon {
  public static void main(String[] args) {
    System.out.println("This is Amazon round===");
    Amazon amazon = new Amazon();

    ArrayList<Integer> startIndices = new ArrayList<Integer>();
    startIndices.add(1);
    startIndices.add(1);

    ArrayList<Integer> endIndices = new ArrayList<Integer>();
      endIndices.add(5);
      endIndices.add(6);
    amazon.itemsInContainer("|******|****", new int[] {1, 1}, new int[] {5, 10});
    /*amazon.itemsInContainerApproachTwo("|******|****"
        , startIndices
        , endIndices
    );*/
  }

    private List<Integer> itemsInContainerApproachTwo(
            String s, ArrayList<Integer> startIndices, ArrayList<Integer> endIndices) {
        /*
         * if string is empty or arrays do not have any value then we do not want to process them further.
         * */
        if (s.isEmpty() || startIndices.size() == 0 || endIndices.size() == 0) {
            return new ArrayList<Integer>();
        }
        // If both the indices array are not equal return with out processing.
        if (startIndices.size() != endIndices.size()) {
            return new ArrayList<Integer>();
        }
        Map<Integer, Character> indiceNumberToPipe = new HashMap<Integer, Character>();
        for(int i=1; i <= s.length(); i++){
            if(s.charAt(i-1) == '|'){
                indiceNumberToPipe.put(i, '|');
            }
        }
        System.out.println("THis is indiceNumberToPipe===== "+ indiceNumberToPipe);

        for(int  i=0; i<startIndices.size(); i++){
            int startIndex = startIndices.get(i);
            int endIndice = endIndices.get(i);
            if(startIndices.contains(startIndex)){

            }
        }
        return null;
    }

  public List<Integer> itemsInContainer(String s, int[] startIndices, int[] endIndices) {
    /*
     * if string is empty or arrays do not have any value then we do not want to process them further.
     * */
    if (s.isEmpty() || startIndices.length == 0 || endIndices.length == 0) {
      return new ArrayList<Integer>();
    }
    // If both the indecs array are not equal return with out processing.
    if (startIndices.length != endIndices.length) {
      return new ArrayList<Integer>();
    }
    int count = 0;
    int startLength = startIndices.length;

    List<Integer> result = new ArrayList<Integer>();
    try {
      while (count < startLength) {
        // We separated the substring as per the start and end indices from arguments.
        String newStr = s.substring((startIndices[count] - 1), (endIndices[count]));
        System.out.println("====" + newStr);
        // We will consider that if substring is empty then 0 is output;
        if (!newStr.isEmpty()) {
          // for counting astrix
          int astCounter = 0;
          // To get the index first pipe in substring
          int indexOfFirstPipeInNewStr = -1;
          // To get the index last pipe in substring
          int indexOfLastPipeInNewStr = -1;
          /*Loop on the substring. Second loop but KMP is tough to implement. This gets the first
            and last index where pipe occured.
          */
          for (int i = 0; i < newStr.length(); i++) {
            // Initialized the value to -1 so if we caught | and -1 then it is first | occurrence
            if (indexOfFirstPipeInNewStr == -1 && newStr.charAt(i) == '|') {
              indexOfFirstPipeInNewStr = i;
            }
            // if we don't have -1 and encounter | then add the value of i to
            // indexOfLastPipeInNewStr.
            if (indexOfFirstPipeInNewStr != -1 && newStr.charAt(i) == '|') {
              indexOfLastPipeInNewStr = i;
            }
          }
          System.out.println("Tnis is indexOfFirstPipeInNewStr==" + indexOfFirstPipeInNewStr);
          System.out.println("Tnis is indexOfLastPipeInNewStr==" + indexOfLastPipeInNewStr);
          // Since we know now that between indexOfFirstPipeInNewStr and indexOfLastPipeInNewStr we
          // should coun
          // every astrix
          for (int i = indexOfFirstPipeInNewStr; i <= indexOfLastPipeInNewStr; i++) {
            if (newStr.charAt(i) == '*') {
              astCounter++;
            }
          }
          // The the whatever counter you got.
          result.add(astCounter);
        } else {
          result.add(0);
        }
        // increase to get next entry in the start and end indices
        count++;
        System.out.println("\n\n");
      }
    } catch (Exception excp) {
      System.out.println("Exception :: " + excp.getMessage() + "\n\n" + excp.getStackTrace());
      return null;
    }
    System.out.println("What we return is :: " + result);
    return result;
  }
}
