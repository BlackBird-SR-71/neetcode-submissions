class Solution {
    public String longestPalindrome(String s) {
        int mx = 0;
        String res = "";

        int len = s.length();
        for (int i = 0; i < len; i++) {


            int l = i;
            int r = i;

            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > mx) {
                    mx = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }

            l = i;
            r =  i + 1;

            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > mx) {
                    mx = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }


        return res;
    }
}
