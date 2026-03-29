class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    double median = 0d;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());

        large = new PriorityQueue<>();


    }
    
    public void addNum(int num) {

        small.offer(num);

        if (!large.isEmpty()) {
            while (small.peek() > large.peek()) {
                large.offer(small.poll());
            }
        }

        if (small.size() - large.size() > 1) {
            large.offer(small.poll());
        }

        if (large.size() - small.size() > 1) {
            small.offer(large.poll());
        }
        
    }
    
    public double findMedian() {

        if (small.size() > large.size()) {
            return small.peek();
        }
        else if (large.size() > small.size()) {
            return large.peek();
        }
        else {
            return (small.peek() + large.peek()) / 2.0;
        }
        
    }
}
