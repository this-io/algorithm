package implementation.medium;

public class PlatesBetweenCandles {
    public static void main(String[] args) {
        PlatesBetweenCandles p = new PlatesBetweenCandles();
        //String ip = "**|**|***|";
        String ip = "***|**|*****|**||**|*";
        //int[][] q = {{2, 5}, {5, 9}};
        int[][] q = {{1,17},{4,5},{14,17},{5,11},{15,16}};
        p.platesBetweenCandles(ip, q);
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            String sbString = s.substring(queries[i][0], queries[i][1] + 1);
            answer[i] = numberOfPlates(sbString);
        }
        for(int i : answer) {
            System.out.print(i + "\t");
        }
        return answer;
    }

    private int numberOfPlates(String theString) {
        int numPlates = 0;
        boolean firstPlateFound = false;
        int innerCount = 0;
        for(char c : theString.toCharArray()) {
            if(firstPlateFound) {
                if(c == '*') {
                    innerCount++;
                } else {
                    numPlates += innerCount;
                    innerCount = 0;
                }
            } else if(c == '|' && !firstPlateFound) {
                firstPlateFound = true;
            }
        }

        return numPlates;
    }

    /*
    * public int[] platesBetweenCandles(String s, int[][] queries) {


        int n = s.length();

        int[] nearestRightCandle = new int[n];
        int[] nearestLeftCandle = new int[n];
        int[] candleCount = new int[n];
        int[] ans = new int[queries.length];

        int candle = -1;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '|') {
                candle = i;
            }
            nearestLeftCandle[i] = candle;
        }

        candle = -1;
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == '|') {
                candle = i;
            }
            nearestRightCandle[i] = candle;
        }

        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '|') {
                ++count;
            }
            candleCount[i] = count;
        }

        int idx = 0;
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];

            int leftCandle = nearestRightCandle[left];
            int rightCandle = nearestLeftCandle[right];

            int d = 0;
            if (leftCandle == -1 || rightCandle == -1) {
                ans[idx] = 0;
            } else {
                d = rightCandle - leftCandle;
                if (d > 1) {
                    ans[idx] = rightCandle - leftCandle + 1 - (candleCount[rightCandle] - candleCount[leftCandle] + 1);
                } else {
                    ans[idx] = 0;
                }
            }

            ++idx;
        }

        return ans;
    }*/
}
