class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        int[][] pair = new int[len][2];

        for (int i = 0; i < len; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        Double slowest = (double) Integer.MIN_VALUE;
        int res = 0;

        for (int[] p : pair) {
            double sp = (double) (target - p[0]) / p[1];

            if (!slowest.equals(Integer.MIN_VALUE) && slowest >= sp) {
                continue;
            }
            else {
                slowest = sp;
                res++;
            }
        }

        return res;
    }
}
