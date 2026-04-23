class Solution {
    public int[] plusOne(int[] digits) {
        long num = 0;
        for (int n: digits) {
            num = num*10+n;
        }
        System.out.println(num);
        num++;
        System.out.println(num);
        List<Long> res = new ArrayList<>();
        while (num>0) {
            res.add(num%10);
            num/=10;
        }
        Collections.reverse(res);
        return res.stream().mapToInt(Long::intValue).toArray();
    }
}
