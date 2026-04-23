class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums, int index, List<Integer> arr) {
        if (index == nums.length) {
            if (arr.size() == nums.length) {
                res.add(List.copyOf(arr));
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (arr.indexOf(nums[i])!=-1) {
                continue;
            }
            arr.add(nums[i]);
            backtrack(nums, index+1, arr);

            arr.remove(arr.size()-1);
            backtrack(nums, index+1, arr);
        }
    }
}
