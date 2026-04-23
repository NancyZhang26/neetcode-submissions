class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return list;
    }

    public void backtrack(int[] arr, int index, ArrayList<Integer> res) {
        if (index == arr.length) {
            list.add(List.copyOf(res));
            return;
        }

        res.add(arr[index]);

        backtrack(arr, index+1, res);
        res.remove(res.size()-1);

        backtrack(arr, index+1, res);
    }


}
