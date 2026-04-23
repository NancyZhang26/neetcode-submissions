class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        ArrayList<int[]> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            list.add(new int[]{entry.getValue(), entry.getKey()});
        }

        list.sort((a, b)->b[0]-a[0]);

        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = list.get(i)[1];
        }

        return output;
    }
}
