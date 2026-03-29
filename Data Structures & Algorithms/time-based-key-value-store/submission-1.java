class TimeMap {

    private Map<String, List<Pair<Integer, String>>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timeStamp) {
        String res = "";
        List<Pair<Integer, String>> pairs = keyStore.getOrDefault(key, new ArrayList<>());

        int l = 0;
        int r = pairs.size() - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (pairs.get(m).getKey() <= timeStamp) {
                res = pairs.get(m).getValue();
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }
        return res;
    }
}
