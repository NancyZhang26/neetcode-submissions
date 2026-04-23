class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length-k+1];
        int l = 0; int r = 0;
        Deque<Integer> q = new LinkedList<>();

        while (r < nums.length) {
            while (!q.isEmpty() && nums[r] > nums[q.getLast()]) {
                q.removeLast();
            }
            q.addLast(r);

            if (l > q.getFirst()) {
                q.removeFirst();
            }

            if (r+1 >= k) {
                output[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }

        return output;
    }
}
