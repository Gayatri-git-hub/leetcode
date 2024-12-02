class Building{
    int height;
    int index;

    public Building(int h, int i){
        height = h;
        index = i;
    }
}

class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Building> stk = new Stack<>();

        for (int i = heights.length-1; i >= 0; i--) {

            if(i == heights.length-1) {
                stk.push(new Building(heights[i], i));
                continue;
            }
            if(heights[i] <= stk.peek().height) continue;
            else stk.push(new Building(heights[i], i));            
        }
        int[] ans = new int[stk.size()];
        for (int i = 0; i < ans.length; i++) {
           ans[i]=stk.pop().index;
        }

        return ans;
    }
}