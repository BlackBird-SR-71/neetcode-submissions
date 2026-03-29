class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];

        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 1; i <= k + 1; i++) {
            int[] temp = Arrays.copyOf(prices, n);

            for (int[] edge : flights) {
                int s = edge[0];
                int d = edge[1];
                int p = edge[2];

                if (prices[s] == Integer.MAX_VALUE) {
                    continue;
                }
                if (prices[s] + p < temp[d]) {
                    temp[d] = prices[s] + p;
                }
            }
            prices = temp;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];

    
    }
}
