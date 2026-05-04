class Solution {
    public int[] findOrder(int num, int[][] prereq) {
        int[] in = new int[num];


        Map<Integer, List<Integer>> map = new HashMap<>();


        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < num; i++) {
            map.put(i, new ArrayList<>());
            
        }


        for (int[] pre : prereq) {
            map.get(pre[0]).add(pre[1]);
            in[pre[1]]++;
        }

        for (int i = 0; i < num; i++) {
            if (in[i] == 0) {   
                q.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (!q.isEmpty()) {
            int top = q.poll(); 
            res.add(top);
            count++;

            for (int adj : map.get(top)) {
                in[adj]--;
                if (in[adj] == 0) {
                    q.offer(adj);
                }
            }
        }
        Collections.reverse(res);
        return count == num ? res.stream().mapToInt(i -> i).toArray() : new int[0];
    }
}
