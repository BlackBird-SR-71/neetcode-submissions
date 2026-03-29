class Solution {
    public int trap(int[] arr) {
        int lmax = arr[0];
        int rmax = arr[arr.length-1];
        int l = 0;
        int r = arr.length-1;

        int res = 0;

        while (l <= r) {
            // rmax = Math.max(arr[r], rmax);
            if (lmax <= rmax) {
                if (arr[l] < lmax) {
                    res += lmax - arr[l];
                } 
                else {
                    lmax = arr[l];
                }
                l++;    
            }
            else {
                if (arr[r] < rmax) {
                    res += rmax - arr[r];
                }
                else {
                    rmax = arr[r];
                }
                r--;
            }
        }
        return res;
    }
}
