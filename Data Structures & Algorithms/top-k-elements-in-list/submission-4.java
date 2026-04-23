class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1); // Use getOrDefault instead of if statements
        } 

        ArrayList<Integer>[] bucket = new ArrayList[nums.length+1]; // List declaration syntax
        for (int i = 0; i < bucket.length; i++) { // Remember to declare at each spot
            bucket[i] = new ArrayList<>();
        }

        for (int key: map.keySet()) {
            bucket[map.get(key)].add(key); // map.get(key) is the frequency
        }

        int[] output = new int[k];
        int index = 0;
        for (int i = bucket.length-1; i >= 0 && index < k; i--) {
            for (int n = 0; n < bucket[i].size(); n++) {
                output[index] = bucket[i].get(n);
                index++;
            }
        }

        return output;
    }
}
