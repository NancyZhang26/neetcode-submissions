class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] arr = s1.toCharArray();
        Arrays.sort(arr);
        String str = new String(arr);

        for (int i = 0; i < s2.length(); i++) {
            for (int j = i; j < s2.length(); j++) {
                String temp = s2.substring(i, j+1);
                char[] temp2 = temp.toCharArray();
                Arrays.sort(temp2);
                String comp = new String(temp2);

                if (str.equals(comp)) {
                    return true;
                }
            }
        }

        return false;
    }
}
