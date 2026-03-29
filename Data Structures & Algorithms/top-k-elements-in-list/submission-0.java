class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            q.offer(new int[]{entry.getValue(), entry.getKey()});

            if (q.size() > k) q.poll();
        }
        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = q.poll()[1];
        }

        return res;
    }
}
