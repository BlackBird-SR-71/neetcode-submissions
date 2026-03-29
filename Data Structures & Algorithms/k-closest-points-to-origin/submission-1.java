class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        // PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Math.pow(b[0], 2) + Math.pow(b[1], 2) - Math.pow(a[0], 2) + Math.pow(a[1], 2));

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        int n = points.length;
        int[][] res = new int[k][2];

        for (int[] point : points) {
            q.add(point);

            while (q.size() > k) {
                q.poll();
            }
            
        }
        

        for (int i = 0; i < k; i++) {
            res[i] = q.poll();
        }
        return res;
    }
}
