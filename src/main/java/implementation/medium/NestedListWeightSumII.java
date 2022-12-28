package implementation.medium;

import java.util.List;

public class NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedIntegers) {
        int maxDepth = findMaxDepth(nestedIntegers);
        System.out.println("This : " + maxDepth);
        return weight(nestedIntegers, 1, maxDepth);
    }

    private int findMaxDepth(List<NestedInteger> nestedIntegers) {
        int maxDepth = 1;
        for (NestedInteger n : nestedIntegers) {
            if (!n.isInteger()) {
                maxDepth = Math.max(maxDepth, 1 + findMaxDepth(n.getList()));
            }
        }

        return maxDepth;
    }

    private int weight(List<NestedInteger> nestedIntegers, int depth, int maxDepth) {
        int ans = 0;

        for (NestedInteger n : nestedIntegers) {
            if (n.isInteger()) {
                ans += n.getInteger() * (maxDepth - depth + 1);
            } else {
                ans += weight(n.getList(), depth + 1, maxDepth);
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
        public void add(NestedListWeightSum.NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
