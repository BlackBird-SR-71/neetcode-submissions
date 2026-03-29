class KthLargest {
    int size;
    PriorityQueue<Integer> queue;
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(Arrays.stream(nums).boxed().toList());

        size = k;

    }
    
    public int add(int val) {
        queue.add(val);
        while (queue.size() > size) {
            queue.poll();
        }
        return queue.peek();
    }
}
