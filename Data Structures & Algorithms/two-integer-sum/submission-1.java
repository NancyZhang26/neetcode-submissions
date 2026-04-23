class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] output = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (map.containsKey(num)) {
                int[] numbers = {map.get(num), i};
                return numbers;
            }

            map.put(diff, i);

        }

        return output;
    }
}
