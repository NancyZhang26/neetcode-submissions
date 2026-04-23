class Solution {
    public int search(int[] nums, int target) {
        int index = findIndex(nums);
        int lo = 0; int hi = index-1;
        if (nums[lo]==target) return lo;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            int num = nums[mid];
            if (num==target) {
                return mid;
            } else if (num < target) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        lo = index; hi = nums.length-1;
        if (nums[lo]==target) return lo;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            int num = nums[mid];
            if (num==target) {
                return mid;
            } else if (num < target) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return -1;
    }

    public int findIndex(int[] nums) {
        int lo = 0; int hi = nums.length-1;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            int num = nums[mid];
            if (mid==0 && num <= nums[nums.length-1]) {
                return mid;
            } else if (num < nums[hi]) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return lo;
    }
}
