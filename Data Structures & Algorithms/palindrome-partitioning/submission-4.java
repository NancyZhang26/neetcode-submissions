class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> part = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        dfs(s, 0, 0);
        return res;
    }

    public void dfs(String s, int begin, int end) {
        if (end == s.length()) {
            if (begin==end) {
                res.add(List.copyOf(part));
            }
            return;
        }

        if (isPalin(s, begin, end)) {
            part.add(s.substring(begin, end+1));

            dfs(s, end+1, end+1);
            part.remove(part.size()-1);
        }

        dfs(s, begin, end+1);
    }

    public boolean isPalin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }


}
