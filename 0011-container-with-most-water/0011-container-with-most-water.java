class Solution {
    public int maxArea(int[] height) {

        int maxArea = 0;
        int left = 0, right= height.length -1;
        int h, w, area;

        while (left < right)    {
            h = Math.min(height[left], height[right]);
            w = right - left;
            area = h * w;
        
            maxArea = Math.max(area, maxArea);

            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;

/*        //int[] actualHeight = int[1];
        int area1 = 0;
        int area2 = 0;
        //int size = height.length;
       // int heightOfI;
        //int heightOfJ;

        for(int i=0; i< height.length-1;i++)    {
            for(int j=i+1; j < height.length; j++)   {
          //      heightOfI = height[i];
          //      heightOfJ = height[j];
                if(height[i] <= height[j])   {
                    area2 = height[i] * (j-i);
                }else   {
                    area2 = height[j] * (j-i);
                }

                if(area1 < area2)   {
                    area1 = area2;
                }
            }
        }
        return area1;
*/
    }
   
}