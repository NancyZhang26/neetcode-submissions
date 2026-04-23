class Solution {
    List<List<String>> list = new ArrayList<>();
    List<String> divide = new ArrayList<>();
    int glob = 0;

    public List<List<String>> partition(String s) {
        dfs(s, 0, 0);
        return list;
    }

    public void dfs(String s, int start, int end) {
        System.out.println(glob);
        if (end >= s.length()) {
            System.out.println(")))");
            if (start==end) {
                list.add(List.copyOf(divide));
            }
            return;
        }

        if (isPalindrome(s, start, end)) {
            divide.add(s.substring(start, end+1));

            dfs(s, end+1, end+1);

            divide.remove(divide.size()-1);
        }

        dfs(s, start, end+1);

    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++; end--;
        }

        return true;
    }

}
