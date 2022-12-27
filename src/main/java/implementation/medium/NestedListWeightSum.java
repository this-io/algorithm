package implementation.medium;

import java.util.List;

public class NestedListWeightSum {

    public static void main(String[] args) {

    }

    public int depthSum(List<NestedInteger> nestedList) {
        int ans = dfs(nestedList, 1);
        return 0;
    }

    private int dfs(List<NestedInteger> l, int depth) {
        int ans = 0;
        for(NestedInteger n : l) {
            if(n.isInteger()) {
                ans += n.getInteger() * depth;
            } else {
                ans += dfs(n.getList(), depth + 1);
            }
        }

        return ans;
    }


    public interface NestedInteger {
        /*// Constructor initializes an empty nested list.
        public NestedInteger();

        // Constructor initializes a single integer.
        public NestedInteger(int value);*/

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
