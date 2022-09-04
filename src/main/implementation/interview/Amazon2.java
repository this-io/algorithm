package main.implementation.interview;

import java.util.ArrayList;
import java.util.List;

public class Amazon2 {
    public List<Integer> itemsInContainer(
            String s, List<Integer> startIndices, List<Integer> endIndices) {
        /*
         * if string is empty or arrays do not have any value then we do not want to process them further.
         * */
        if (s.isEmpty() || startIndices.size() == 0 || endIndices.size() == 0) {
            return new ArrayList<Integer>();
        }
        // If both the indecs array are not equal return with out processing.
        if (startIndices.size() != endIndices.size()) {
            return new ArrayList<Integer>();
        }
        int count = 0;
        int startLength = startIndices.size();

        List<Integer> result = new ArrayList<Integer>();
        try {
            while (count < startLength) {
                System.out.println("======");
                if (s.length() < startIndices.get(count) || s.length() < endIndices.get(count)) {
                    result.add(0);
                } else {

                    // We separated the substring as per the start and end indices from arguments.
                    String newStr = s.substring((startIndices.get(count) - 1), (endIndices.get(count)));

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
                        // Since we know now that between indexOfFirstPipeInNewStr and indexOfLastPipeInNewStr
                        // we should coun
                        // every astrix
                        if (indexOfLastPipeInNewStr == -1) {
                            for (int i = indexOfFirstPipeInNewStr; i <= indexOfLastPipeInNewStr; i++) {
                                if (newStr.charAt(i) == '*') {
                                    astCounter++;
                                }
                            }
                        } else {
                            astCounter = 0;
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
            }
        } catch (Exception excp) {
            System.out.println("Exception :: " + excp.getMessage() + "\n\n" + excp.getStackTrace());
            return null;
        }
        System.out.println("What we return is :: " + result);
        return result;
    }
}
