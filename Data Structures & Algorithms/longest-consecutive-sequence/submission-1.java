class Solution {
    public int longestConsecutive(int[] nums) {
        int length = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        for (int num: nums) {
            if (!set.contains(num-1)) { // If it is a start...
                int i = 0;
                while (set.contains(num+i)) { 
                    i++;
                }
                length = Math.max(length, i);
            }
        }

        return length;
    }
}
