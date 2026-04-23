class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character, Character> h = new HashMap<>();

        h.put(']','['); h.put('}','{'); h.put(')','(');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==']'|| s.charAt(i)=='}'|| s.charAt(i)==')') {
                if (!st.isEmpty() && st.peek().equals(h.get(s.charAt(i)))) {
                    st.pop();
                } else {
                    return false;
                }
            } else {
                st.push(s.charAt(i));
            }
        }

        return st.isEmpty();
    }
}
