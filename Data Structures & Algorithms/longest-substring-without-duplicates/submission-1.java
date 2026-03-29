class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();

        int res = 0;

        int start = 0;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                int temp = map.get(s.charAt(i));
                if (temp >= start) {
                    start = temp + 1;
                }
                
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
