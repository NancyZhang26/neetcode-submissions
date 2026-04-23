class Solution {
    public boolean isPalindrome(String input) {
        String ref = input.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(ref);
        int start = 0;
        int end = ref.length()-1;
        while (start < end) {
            if (ref.charAt(start)!=ref.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
