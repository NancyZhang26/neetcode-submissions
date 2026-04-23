class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder s = new StringBuilder();
        List<String> r = new ArrayList<>();
        backtrack(n, 0, 0, s, r);
        return r;
    }

    public void backtrack(int n, int open, int close, StringBuilder stack, List<String> res) {
        if (open == close && open == n) {
            res.add(stack.toString());
            return;
        }

        if (open < n) {
            stack.append("(");
            backtrack(n, open+1, close, stack, res);
            stack.deleteCharAt(stack.length()-1);
        }

        if (close < open) {
            stack.append(")");
            backtrack(n, open, close+1, stack, res);
            stack.deleteCharAt(stack.length()-1);
        }
    }
}
