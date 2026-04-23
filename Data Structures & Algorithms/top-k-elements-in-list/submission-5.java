class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        ArrayList<Integer>[] bucket = new ArrayList[nums.length+1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        for (int num: map.keySet()) {
            bucket[map.get(num)].add(num);
        }

        int index = 0;
        int[] output = new int[k];
        for (int i = bucket.length-1; i >= 0 && index < k; i--) {
            for (int n = 0; n < bucket[i].size(); n++) {
                output[index] = bucket[i].get(n);
                index++;
            }
        }

        return output;

    }
}
