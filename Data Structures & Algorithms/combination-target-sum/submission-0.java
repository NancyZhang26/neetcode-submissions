class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtracking(nums, new ArrayList<>(), 0, target, 0);
        return list;
    }

    public void backtracking(int[] arr, List<Integer> cur, int index, int target, int sum) {
        if (target==sum) {
            list.add(List.copyOf(cur));
            return;
        }
        if (index == arr.length || sum > target) {
            return;
        }

        cur.add(arr[index]);
        sum += arr[index];
        backtracking(arr, cur, index, target, sum);

        cur.remove(cur.size()-1);
        sum-=arr[index];
        backtracking(arr, cur, index+1, target, sum);
    }
}
