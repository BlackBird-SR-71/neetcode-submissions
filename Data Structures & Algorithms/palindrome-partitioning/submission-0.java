class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();

        List<String> temp = new ArrayList<>();

        dfs(0, s, temp);
        return res;
        
    }

    private void dfs(int i, String s, List<String> temp) {
        if (i == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int idx = i; idx < s.length(); idx++) {
            String substr = s.substring(i, idx + 1);
            if (isPalindrome(substr)) {
                temp.add(substr);
                dfs(idx + 1, s, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    
}
