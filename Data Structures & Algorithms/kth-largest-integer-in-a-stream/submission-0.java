class KthLargest {

    PriorityQueue<Integer> pq;
    int rank;
    ArrayList<Integer> arr;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>((a, b) -> b-a);
        this.rank = k;
        this.arr = new ArrayList<>();

        for (int i: nums) {
            arr.add(i);
        }
    }
    
    public int add(int val) {
        pq.clear();
        arr.add(val);

        System.out.println(arr);

        for (int i: arr) {
            pq.offer(i);
        }

        for (int i = 0; i < rank-1; i++) {
            pq.poll();
        }

        return pq.peek();
    }
}
