class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        Arrays.stream(stones).forEach(stone -> queue.add(stone));

        while (queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();

            if (x < y) {
                queue.add(y - x);
            } else if (y < x) {
                queue.add(x - y);
            }
            
        }
        return queue.size() == 1 ? queue.poll() : 0;


    }
}
