class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> part = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0, 0);
        return res;
    }

    public void dfs(String str, int start, int end) {
        if (end == str.length()) {
            if (start == end) {
                res.add(List.copyOf(part));
            }
            return;
        }

        if (isPalin(str, start, end)) {
            part.add(str.substring(start, end+1));

            dfs(str, end+1, end+1);

            part.remove(part.size()-1);
        }

        dfs(str, start, end+1);
    }

    public boolean isPalin(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
