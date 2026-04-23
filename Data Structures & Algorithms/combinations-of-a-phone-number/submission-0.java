class Solution {
    HashMap<Character, String> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(digits, 0, "");
        return res;
    }

    public void backtrack(String digit, int index, String str) {
        if (index == digit.length()) {
            if (!str.equals("")) res.add(str);
            return;
        }

        String alphabets = map.get(digit.charAt(index));

        for (int i = 0; i < alphabets.length(); i++) {
            str += alphabets.charAt(i);
            backtrack(digit, index+1, str);
            str = str.substring(0, str.length()-1);
        }
    }
}
