class Solution {
    HashSet<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());

        for (List<Integer> l: res) {
            ans.add(l);
        }

        return ans;
    }

    public void backtrack(int[] nums, int index, ArrayList<Integer> re) {
        if (index == nums.length) {
            res.add(List.copyOf(re));
            return;
        }

        re.add(nums[index]);
        backtrack(nums, index+1, re);
        
        re.remove(re.size()-1);
        backtrack(nums, index+1, re);
    }
}

