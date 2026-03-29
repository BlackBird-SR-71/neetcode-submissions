class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] sorted = new int[n][2];

        for (int i = 0; i < n; i++) {
            sorted[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(sorted, Comparator.comparingInt(o -> o[0]));

        double[] res = new double[n];

        Set<Double> set = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            double temp = (((target - sorted[i][0]) * 1.0) / sorted[i][1]);
            if (i < n - 1 && temp < res[i + 1]) {
                res[i] = res[i + 1];
            }
            else {
                res[i] = temp;
            }
            set.add(res[i]);
        }
        return set.size();
    }
}
