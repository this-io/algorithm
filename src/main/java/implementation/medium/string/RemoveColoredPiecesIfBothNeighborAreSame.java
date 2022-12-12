package implementation.medium.string;

public class RemoveColoredPiecesIfBothNeighborAreSame {
    public static void main(String[] args) {
        RemoveColoredPiecesIfBothNeighborAreSame r = new RemoveColoredPiecesIfBothNeighborAreSame();
        //System.out.println(r.winnerOfGame("AAABABB"));
        //System.out.println(r.winnerOfGame("AA"));
        System.out.println(r.winnerOfGame("ABBBBBBBAAA"));
        //System.out.println(r.winnerOfGame("BBAAABBABBABB"));
        //System.out.println(r.winnerOfGame("BAABABBAAA"));
    }

    public boolean winnerOfGame(String colors) {
        if (colors.isBlank()) {
            return true;
        }

        int alice = 0;
        int bob = 0;

        for(int i=1; i<colors.length() - 1; i++) {
            if(colors.charAt(i) == colors.charAt(i - 1) && colors.charAt(i) == colors.charAt(i + 1)) {
                if(colors.charAt(i) == 'A') {
                    alice++;
                } else {
                    bob++;
                }
            }
        }

        return alice > bob;
    }


}
