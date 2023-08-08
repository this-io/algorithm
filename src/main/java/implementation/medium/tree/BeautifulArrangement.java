package implementation.medium.tree;

public class BeautifulArrangement {
    int res = 0;
    public static void main(String[] args) {
        BeautifulArrangement b = new BeautifulArrangement();
        b.countArrangement(3);
    }

    public int countArrangement(int n) {

        int[] nums = new int[n+1];
        dfs(nums, 1, n);
        System.out.println(res);
        return res;
    }

    void dfs(int[] nums, int val, int n) {
        if(val > n) {
            res++;
            return;
        }

        for(int i=1; i<=n; i++) {
            if(nums[i] == 0 && (val % i ==0 || i % val == 0)) {
                nums[i] = val;
                dfs(nums, val+1, n);
                nums[i] = 0;
            }
        }
    }
}
