class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            int num = i+1;
            while (num < temperatures.length && temperatures[num]<=temp) {
                num++;
            }
            if (num == temperatures.length) {
                res[i] = 0;
            } else {
                res[i] = num-i;
            }
        }
        return res;
    }
}
