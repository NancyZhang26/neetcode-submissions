public class Solution {
    public int trap(int[] height) {
        int output = 0;
        if (height == null || height.length == 0) {
            return output;
        }

        int l = 0; int r = height.length-1;
        int leftMax = 0; int rightMax = 0;
        while (l<r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                output += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                output += rightMax - height[r];
            }
        }

        return output;
    }
}
