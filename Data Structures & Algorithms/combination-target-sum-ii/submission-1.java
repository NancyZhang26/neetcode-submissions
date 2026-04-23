class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        backtrack(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }

    public void backtrack(int[] candidates, int target, int index, List<Integer> hold, int curr) {
        if (curr==target && !contains(res, hold)) {
            res.add(List.copyOf(hold));
            return;
        }
        
        if (index == candidates.length || curr > target) {
            return;
        }

        hold.add(candidates[index]);
        curr += candidates[index];

        System.out.println(hold);

        backtrack(candidates, target, index+1, hold, curr);

        curr -= candidates[index];
        hold.remove(hold.size()-1);

        System.out.println(hold);

        backtrack(candidates, target, index+1, hold, curr);
    }

    public boolean contains(List<List<Integer>> arr, List<Integer> in) {
        for (List<Integer> l: arr) {
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();
            for (int i: l) {
                set1.add(i);
            }
            for (int n: in) {
                set2.add(n);
            }
            if (set1.equals(set2)) return true;
        }
        return false;
    }
}
