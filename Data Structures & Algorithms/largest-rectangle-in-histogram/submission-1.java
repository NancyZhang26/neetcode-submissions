class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int area = heights[i];
            int min = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                area = min*(j-i+1);
                //System.out.println("The min between "+heights[i]+" and "+heights[j]+" is "+
                //min+" and use it to times "+(j-i+1)+" which is "+area);
                max = Math.max(max, area);          
            }
        }
        return max;
    }
}
