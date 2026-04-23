class Solution {
    //1 2 3 4 5 6
    //6 1 2 3 4 5
    //5 6 1 2 3 4
    //4 5 6 1 2 3
    //3 4 5 6 1 2
    //2 3 4 5 6 1

    public int findMin(int[] nums) {
        if (nums[0]<=nums[nums.length-1]) return nums[0];
        int start = 0; int end = nums.length-1;
        while (start < end) {
            int mid = start + (end-start)/2;
            if (mid==0 && nums[mid]<=nums[nums.length-1]) {
                return nums[mid];
            } else if (nums[mid]>nums[end]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}
