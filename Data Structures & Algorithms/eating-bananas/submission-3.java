class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        int r = Integer.MIN_VALUE;

        for (int i : piles) {
            r = Math.max(r, i);
        }
        int res = r;

        while (l <= r) {
            int m = (l + r + 1) / 2;
            int hours = 0;
            for (int ban : piles) {
                hours += Math.ceil((ban * 1.0) / m); 
            }
            
            if (hours <= h) {
                r = m - 1;
                res = Math.min(res, m);
            }
            else if (hours > h) {
                l = m + 1;
            }
        }

        return res;
    }
}
