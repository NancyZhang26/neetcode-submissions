class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int maxf = 0;
        int output = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            maxf = Math.max(maxf, map.get(s.charAt(i)));
            while (i-l+1 - maxf > k) {
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
            }
            output = Math.max(output, i-l+1);
        }
        return output;
    }
}
