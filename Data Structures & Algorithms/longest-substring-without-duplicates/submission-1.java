class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ptr = 0;
        int output = 0;
        int start = 0; int end = 0;
        while (ptr < s.length()) {
            if (map.containsKey(s.charAt(ptr))) {
                start = Math.max(map.get(s.charAt(ptr))+1, start);
            }
            map.put(s.charAt(ptr), ptr);
            end++;
            ptr++;
            output = Math.max(s.substring(start, end).length(), output);
        }
        return output;
    }
}
