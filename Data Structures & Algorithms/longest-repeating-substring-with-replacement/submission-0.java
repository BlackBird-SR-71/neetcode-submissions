class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>(26);
        char[] str = s.toCharArray();
        int l = 0;
        int r = 0;

        int res = 0;
        int curr = 0;

        while (r < str.length) {
            map.put(str[r], map.getOrDefault(str[r], 0) + 1);

            if ((r - l + 1) - getMaxFreq(map) <= k) {
                res = Math.max(res, (r - l + 1));
            }
            else {
                map.put(str[l], map.get(str[l]) - 1);
                l++;
            }
            r++;
        }
        return res;
    }

    private int getMaxFreq(Map<Character, Integer> map) {
        int maxFreq = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxFreq = Math.max(maxFreq, entry.getValue());
        }
        return maxFreq;
    }
}
