class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tCount = new HashMap<>();
        HashMap<Character, Integer> sCount = new HashMap<>();
        int[] indexes = new int[2];
        int match = 0;
        int output = s.length() + 1;

        if (t.length() > s.length() || t.equals("")) {
            return "";
        }

        for (int i = 0; i < t.length(); i++) {
            tCount.put(t.charAt(i), 1 + tCount.getOrDefault(t.charAt(i), 0));
        }

        int l = 0; int r = 0;

        for (int i = 0; i < s.length(); i++) {
            sCount.put(s.charAt(i), 1 + sCount.getOrDefault(s.charAt(i), 0));
            if (tCount.containsKey(s.charAt(i)) && sCount.get(s.charAt(i)) == tCount.get(s.charAt(i))) {
                match++;
            }
            r=i;

            while (match >= tCount.size()) {
                if (r-l+1 < output) {
                    output = r-l+1;
                    indexes[0] = l; indexes[1] = r;
                }

                sCount.put(s.charAt(l), sCount.get(s.charAt(l))-1);
                if (tCount.containsKey(s.charAt(l)) && tCount.get(s.charAt(l)) > sCount.get(s.charAt(l))) {
                    match--;
                }
                l++;
            }
        }

        if (output < s.length() + 1) {
            return s.substring(indexes[0], indexes[1]+1);
        } else {
            return "";
        }

    }
}
