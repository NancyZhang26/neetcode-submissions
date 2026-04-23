class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr = new int[nums.length - k + 1];
        int l = 0;
        int r = k-1;
        while (r < nums.length) {
            int[] temp = new int[k];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < k; i++) {
                temp[i] = nums[l+i];
                if (temp[i] > max) {
                    max = temp[i];
                }
            }
            arr[l]=max;
            r++;
            l++;
        }
        return arr;
    }
}
