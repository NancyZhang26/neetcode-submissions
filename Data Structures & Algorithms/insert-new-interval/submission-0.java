class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ins = new ArrayList<>(Arrays.asList(intervals));
        ins.add(newInterval);
        ins.sort((a, b) -> a[0]-b[0]);

        //System.out.println("Froggie was here!");

        //13, 25, 46
        int i = 1;
        for (int[] in: ins) {
            for (int n: in) {
                System.out.printf("%d ", n);
            }
        }
        while (i < ins.size()) {
            int[] cur = ins.get(i);
            int[] prev = ins.get(i-1);
            if (cur[0] <= prev[1]) {
                int[] mer = new int[]{Math.min(cur[0], prev[0]), Math.max(cur[1], prev[1])};
                ins.set(i-1, mer);
                ins.remove(i);
                System.out.println(ins);
            } else {
                i++;
            }
        }

        return ins.toArray(new int[ins.size()][]);
    }
}
