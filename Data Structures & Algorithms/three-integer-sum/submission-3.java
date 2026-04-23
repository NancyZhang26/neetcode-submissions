class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break; // Because the array is sorted
            }
            if (i>0 && nums[i]==nums[i-1]) {
                continue; // You encountered a dupe.
            }
            int l = i+1; int r = nums.length-1;
            while (l<r) {
                if (nums[i]+nums[l]+nums[r]>0) {
                    r--;
                } else if (nums[i]+nums[l]+nums[r]<0) {
                    l++;
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]); temp.add(nums[l]); temp.add(nums[r]);
                    output.add(temp);
                    l++;
                    r--;
                    while (l<r && nums[l]==nums[l-1]) {
                        l++;
                    }
                }
            }
        }

        return output;
    }
}
