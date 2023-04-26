package implementation.medium;

public class HitCounter2 {
    static final int MAX_MINUTES = 300;
    public static void main(String[] args) {
        HitCounter2 hc = new HitCounter2();
        String[] op = {"HitCounter", "hit", "hit", "hit", "getHits", "hit", "getHits", "getHits"};
        int[][] timeStamp = {{}, {1}, {2}, {3}, {4}, {300}, {300}, {301}};

        for(int i=0; i<op.length;i++) {
            if(op[i].equalsIgnoreCase("HitCounter")) {

            } else if(op[i].equalsIgnoreCase("hit")) {
                hc.hit(timeStamp[i][0]);
            } else if(op[i].equalsIgnoreCase("getHits")) {
                hc.getHits(timeStamp[i][0]);
            }
        }
    }

    public HitCounter2() {

    }

    public void hit(int timestamp) {

    }

    public int getHits(int timestamp) {
        return 0;
    }
}
