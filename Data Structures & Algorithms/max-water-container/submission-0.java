class Solution {
    public int maxArea(int[] heights) {
        int output = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i+1; j < heights.length; j++) {
                int height = Math.min(heights[i], heights[j]);
                int width = j-i;
                int num = height*width;
                if (num > output) {
                    output = num;
                }
            }
        }
        return output;
    }
}
