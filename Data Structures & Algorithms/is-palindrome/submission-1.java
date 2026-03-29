class Solution {
    public boolean isPalindrome(String temp) {

        int l = 0;
        int r = temp.length()-1;
        if (temp.length() == 0) {
            return true;
        }

        while (l < r) {
            char left  = temp.charAt(l);
            char right  = temp.charAt(r);

            

            if (!Character.isLetterOrDigit(left)) {
                l++;
                continue;
            }

            if (!Character.isLetterOrDigit(right)) {
                r--;
                continue;
                
            }
            if (Character.toLowerCase(temp.charAt(l)) == Character.toLowerCase(temp.charAt(r))) {
                l++;
                r--;
            }
            else {
                return false;
            }
        }

        return true;
    }
}
