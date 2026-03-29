class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = Integer.MIN_VALUE;

        for (int i : piles) {
            r = Math.max(r, i);
        }

        int l = 1;
        int res = r;
        while (l <= r) {
            int m = (l + r) / 2;

            int hrs = calculateHrs(piles, m);
            System.out.println(hrs);
            if (hrs > h) {
                l = m + 1;
            }
            else {
                res = Math.min(res, m);
                r = m - 1;
            }

        }
        return res;
    }

    private int calculateHrs(int[] piles, int k) {
        int hrs = 0;
        for (int i : piles) {
            hrs += Math.ceil((i * 1.0) / k);
        }
        return hrs;
    }
}
