class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> s = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!s.isEmpty() && s.peek()[0] < temp) {
                res[s.peek()[1]] = i-s.peek()[1];
                s.pop();
            }
            s.push(new int[]{temp, i});
        }
        return res;
    }
}
