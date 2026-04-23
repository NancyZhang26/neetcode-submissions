class Solution {
    public int[] productExceptSelf(int[] input) {
        int[] sol = new int[input.length];
        sol[0] = 1;
        for (int i = 1; i < input.length; i++) {
            sol[i] = sol[i-1]*input[i-1];
        }

        int postfix = 1;
        for (int i = input.length-1; i >= 0; i--) {
            sol[i] *= postfix;
            postfix *= input[i];
        }

        return sol;
    }
}  
