class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        Arrays.stream(stones).forEach(e -> pq.add(e));


        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            if (a == b) {
                continue;
            }
            else {
                pq.add(Math.abs(a-b));
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();


    }
}
