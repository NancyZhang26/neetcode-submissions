class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> output = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            } // 5#hello5#world
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = j + length + 1;
            output.add(str.substring(i, j));
            i = j;
        }

        return output;

    }
}
