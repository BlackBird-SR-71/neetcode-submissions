class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(); 
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        int remove = pq.size() - k;
        while (remove > 0) {
            pq.poll();
            remove--;
        }
        
    }
    
    public int add(int val) {
        pq.add(val);
        int count = k;
        Integer res = 0;
        // System.out.println(k);
        // System.out.println(pq.size());
        // System.out.println("----------");

        while (pq.size() != k) {
            pq.poll();
        }
        return pq.peek();
    }
}
