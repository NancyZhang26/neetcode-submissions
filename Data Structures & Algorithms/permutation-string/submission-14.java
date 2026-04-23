class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int match = 0;
        
        char[] s1h = new char[26];
        char[] s2h = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            s1h[s1.charAt(i)-'a']++;
            s2h[s2.charAt(i)-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (s1h[i]==s2h[i]) {
                match++;
            }
        }

        if (match == 26) {
            return true;
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            int index = s2.charAt(r)-'a';
            s2h[index]++;
            if (s1h[index]==s2h[index]) {
                match++;
            } else if (s1h[index]+1==s2h[index]) {
                match--;
            }

            index = s2.charAt(l)-'a';
            s2h[index]--;
            if (s1h[index]==s2h[index]) {
                match++;
            } else if (s1h[index]-1==s2h[index]) {
                match--;
            }

            if (match == 26) {
                return true;
            }
            l++;
        }

        return false;

    }
}



