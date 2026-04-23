class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] arr = s1.toCharArray();
        Arrays.sort(arr);
        String str = new String(arr);

        for (int i = 0; i < s2.length(); i++) {
            for (int j = i; j < s2.length(); j++) {
                char[] helper = s2.substring(i,j+1).toCharArray();
                Arrays.sort(helper);
                String comp = new String(helper);
                if (str.equals(comp)) {
                    return true;
                }
            }
        }

        return false;
    }
}
