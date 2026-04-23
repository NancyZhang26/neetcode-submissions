class Solution {
    public boolean isValidSudoku(char[][] nums) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            rows.put(i, new HashSet<>());
        }
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            cols.put(i, new HashSet<>());
        }
        HashMap<String, HashSet<Character>> grids = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                String key = "";
                key += i/3 + "," + j/3;
                if ((nums[i][j]!='.')&&(rows.get(i).contains(nums[i][j]) || cols.get(j).contains(nums[i][j]) || 
                grids.containsKey(key) && grids.get(key).contains(nums[i][j]))) {
                    return false;
                } else {
                    if (nums[i][j] != '.') {
                        rows.get(i).add(nums[i][j]);
                        cols.get(j).add(nums[i][j]);
                        
                        if (grids.containsKey(key)) {
                            grids.get(key).add(nums[i][j]);
                        } else {
                            grids.put(key, new HashSet<>());
                            grids.get(key).add(nums[i][j]);
                        }
                    }
                }
            }
        }
    
        return true;
    }
    
}
