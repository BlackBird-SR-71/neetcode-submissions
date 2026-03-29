class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        int m = 0;

        // BS on array which has num of possible bananas koko can eat
        // (min: 1 - max: max value in piles)
        while (l <= r) {
            m = (l + r) / 2;
            int mHours = calculateHours(m, piles);
            // if (mHours == h) {
            //     res = m;
            // }
            if (mHours <= h) {
                res = m;
                r = m - 1;
            }
            else if (mHours > h) {
                l = m + 1;
            }
        }
        return res;
    }

    private int calculateHours(int num, int[] piles) {
        int res = 0;
        for (int p : piles) {
            res += Math.ceil((double) p / num);
        }
        return res;
    }
}
