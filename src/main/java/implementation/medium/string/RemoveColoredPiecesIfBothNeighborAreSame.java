package implementation.medium.string;

public class RemoveColoredPiecesIfBothNeighborAreSame {
    public static void main(String[] args) {
        RemoveColoredPiecesIfBothNeighborAreSame r = new RemoveColoredPiecesIfBothNeighborAreSame();
        System.out.println(r.winnerOfGame("AAABABB"));
        System.out.println(r.winnerOfGame("AA"));
        System.out.println(r.winnerOfGame("ABBBBBBBAAA"));
        System.out.println(r.winnerOfGame("BBAAABBABBABB"));
        System.out.println(r.winnerOfGame("BAABABBAAA"));
    }

    public boolean winnerOfGame(String colors) {
        if (colors.isBlank()) {
            return true;
        }

        String playerTurn = "Alice";
        //char[] colorsArray = colors.toCharArray();
//    while (colors.length() != 0) {
//
//      StringBuilder colorBuilder = new StringBuilder(colors);
//      if (playerTurn.equalsIgnoreCase("Alice")) {
//        int position = getColorOut(colors.toCharArray(), 'A');
//        if (position != -1) {
//          colorBuilder.deleteCharAt(position);
//          colors = colorBuilder.toString();
//          playerTurn = "Bob";
//        } else {
//          return false;
//        }
//      } else {
//        int position = getColorOut(colors.toCharArray(), 'B');
//        if (position != -1) {
//          colorBuilder.deleteCharAt(position);
//          colors = colorBuilder.toString();
//          playerTurn = "Alice";
//        } else {
//          return true;
//        }
//      }
//    }

        int aliceWins = getColorOut(colors.toCharArray(), 'A');
        int bobWins = getColorOut(colors.toCharArray(), 'B');
        System.out.println("alice wins :: "+ aliceWins);
        System.out.println("bob wins :: "+ bobWins);
        return (aliceWins > bobWins);
    }

    private int getColorOut(char[] colorArray, char playerChar) {
        int i = 0, j = i + 1;
        char[] colors = colorArray;
        if (j > colorArray.length) {
            return -1;
        }
        int count = 0;
        while (j < colors.length && i < j) {
            if (j - i > 2) {
                j = i + 1;
            }
            if (colorArray[i] == playerChar && colorArray[j] == playerChar) {
                if (j == i + 2) {
                    if (colorArray[i] == colorArray[i + 1]) {
                        StringBuilder colorBuilder = new StringBuilder(String.valueOf(colors));
                        colorBuilder.deleteCharAt(j-1);
                        colors = colorBuilder.toString().toCharArray();
                        count++;
                    }
                }
                j++;
            } else {
                i++;
                j++;
            }
        }
        return count;
    }
}
