class Solution {
    public boolean isValid(String str) {
        if (str == "" || str.length() % 2 == 1) {
            return false;
        }
        Stack<Character> s = new Stack<>();
        HashMap<Character, Character> m = new HashMap<>();
        m.put('}','{');
        m.put(']','[');
        m.put(')','(');
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '}' || str.charAt(i) == ']' || str.charAt(i) == ')') {
                if (!s.isEmpty() && s.peek().equals(m.get(str.charAt(i)))) {
                    s.pop();
                } else {
                    return false;
                }
            } else {
                s.push(str.charAt(i));
            }
        }
        return s.isEmpty();
    
    }
}
