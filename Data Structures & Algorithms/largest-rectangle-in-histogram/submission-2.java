class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> s = new Stack();
        int max = 0;
        int i = 0;
        while (i < heights.length) {
            if (!s.isEmpty() && heights[i]<=s.peek()[1]) {
                int[] last = s.peek();
                while (!s.isEmpty() && heights[i]<=s.peek()[1]) {
                    last = s.pop();
                    max = Math.max(max, last[1]*(i-last[0]));
                }
                s.push(new int[]{last[0], heights[i]});
            } else {
                s.push(new int[]{i, heights[i]});
            }
            i++;
        }
        while (!s.isEmpty()) {
            max = Math.max(max, (heights.length-s.peek()[0])*s.pop()[1]);
        }
        return max;
    }
}
