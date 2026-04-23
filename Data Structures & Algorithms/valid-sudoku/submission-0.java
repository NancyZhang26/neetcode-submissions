class Solution {
    public boolean isValidSudoku(char[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < nums.length; j++) {
                if (nums[i][j] != '.' && !set.add(nums[i][j])) {
                    return false;
                }
            }
 
            HashSet<Character> set2 = new HashSet<>();
            for (int j = 0; j < nums.length; j++) {
                if (nums[j][i] != '.' && !set2.add(nums[j][i])) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i+=3) {
            for (int k = 0; k < 9; k+=3) {
                HashSet<Character> set3 = new HashSet<>();
                for (int j = i; j < i+3; j++) {
                    for (int n = k; n < k+3; n++) {
                        if (nums[j][n] != '.' && !set3.add(nums[j][n])) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
    
}
