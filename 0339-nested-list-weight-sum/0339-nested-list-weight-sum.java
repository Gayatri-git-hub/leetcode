/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        //Approach 1)  O(N), O(M) where M 
        //return bfs(nestedList);

        //Approach 2) -O(N), O(D) where D is max depth in the list
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedList, int depth){
        int result = 0;

        for (NestedInteger ni : nestedList) {
            if(ni.isInteger())
                result += ni.getInteger() * depth;
            else
                result += dfs(ni.getList(), depth + 1); 
        }

        return result;
    }

    private int bfs(List<NestedInteger> nestedList){
        Queue<NestedInteger> que = new LinkedList<>(nestedList);
        int result = 0;
        int depth =1;
        int tempSize = que.size();

        while(!que.isEmpty()){
            int size = que.size();
            for (int i=0; i < size; i++) {
                NestedInteger item = que.poll();
            
                if(item.isInteger()) 
                    result += item.getInteger() * depth;
                else {
                    for (NestedInteger ni : item.getList()) {
                        que.offer(ni);
                    }
                }
            }
            
            depth +=1;
        }

        return result;
    }
}