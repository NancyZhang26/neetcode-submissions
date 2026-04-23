class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str: strs) {
            res.append(str.length()).append("#").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        ArrayList<String> output = new ArrayList<>();
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j)!='#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j+1;
            j = i+length;
            output.add(str.substring(i, j));
            i = j;
        }

        return output;

    }
}
