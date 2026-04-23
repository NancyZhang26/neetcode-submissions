class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for (int x: stones) {
            pq.offer(x);
        }

        while (pq.size()>1) {
            int s1 = pq.poll();
            int s2 = pq.poll();

            if (s1!=s2) {
                pq.offer(Math.max(s1, s2)-Math.min(s1, s2));
            }
        }

        return pq.size()==0?0:pq.poll();
    }
}
