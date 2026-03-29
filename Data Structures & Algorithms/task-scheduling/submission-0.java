class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();

        int[] arr = new int[26];

        for (char c : tasks) {
            arr[c - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                maxHeap.add(arr[i]);
            }
        }

        int time = 0;

        while(!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;
            if (!q.isEmpty() && time > q.peek()[1]) {
                int[] pair = q.poll();
                
                maxHeap.add(pair[0]);
            } 
            if (!maxHeap.isEmpty()) {
                int remaining = maxHeap.poll() - 1;
                if (remaining > 0) {
                    q.add(new int[]{remaining, time + n});
                }
            }
            
        }

        return time;
    }
}
