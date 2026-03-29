class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];

        for (char task : tasks) {
            map[task - 'A']++; 
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);


        for (int count : map) {
            if (count > 0) {
                maxHeap.add(count);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if (maxHeap.isEmpty()) {
                time = q.peek()[1];
            }

            else {
                int count = maxHeap.poll() - 1;
                if (count > 0) {
                    q.add(new int[]{count, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;
    }
}
