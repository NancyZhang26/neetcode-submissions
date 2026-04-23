class Solution {
    //1 2 3 4 5 6
    //6 1 2 3 4 5
    //5 6 1 2 3 4
    //4 5 6 1 2 3
    //3 4 5 6 1 2
    //2 3 4 5 6 1

    public int findMin(int[] nums) {
        if (nums.length==1) return nums[0];
        int start = 0; int end = nums.length-1;
        while (start < end) {
            int mid = start + (end-start)/2;
            int num = nums[mid];

            // System.out.printf("start is: %d\n", start);
            // System.out.printf("end is: %d\n", end);
            // System.out.printf("mid is: %d\n", mid);

            //When to return?
            if (mid==0 && num<nums[nums.length-1] || mid==nums.length-1 && num<nums[0] && num<nums[mid-1] 
            || mid > 0 && mid < nums.length-1 && num<nums[mid-1] && num<nums[mid+1]) {
                return num;
            }
            //When to look in the right?
            else if (mid==0 && num>nums[nums.length-1] || mid > 0 && num>nums[mid-1] && num>nums[nums.length-1]) {
                start = mid+1;
            }
            //When to look in the left?
            else if (mid==nums.length-1 && num>nums[0] || mid > 0 && mid < nums.length-1 && num<nums[mid+1] && num>nums[mid-1]) {
                end = mid-1;
            }
        }
        return nums[start];
    }
}
