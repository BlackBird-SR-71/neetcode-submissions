class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int size = timestamp.length;
        // TS, idx
        int[][] arr = new int[size][2];

        
        for (int i = 0; i < size; i++) {
            arr[i] = new int[]{timestamp[i], i};
        }

        //sort by timestamps;

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        // arr.sort((a, b) -> Integer.compare(a[0], b[0]));


        // group by users;

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            String user = username[arr[i][1]];

            map.computeIfAbsent(user, k -> new ArrayList<>()).add(website[arr[i][1]]);
        }

        // create combinations of 3 for all user visited websites
        Map<String, Integer> score = new HashMap<>();

        for (String user : map.keySet()) {
            List<String> websites = map.get(user);
            Set<String> patterns = new HashSet<>();

            for (int i = 0; i < websites.size(); i++) {
                for (int j = i + 1; j < websites.size(); j++) {
                    for (int k = j + 1; k < websites.size(); k++) {
                        patterns.add(websites.get(i) + "#" + websites.get(j) + "#" + websites.get(k));
                    }
                }
            }
            for (String pattern : patterns) {
                score.put(pattern, score.getOrDefault(pattern, 0) + 1);
            }

        }

        String res = "";
        int count = 0;
        for (Map.Entry<String, Integer> entry : score.entrySet()) {
            if (entry.getValue() > count || (count == entry.getValue() && entry.getKey().compareTo(res) < 0)) {
                res = entry.getKey();
                count = entry.getValue();
            }
        }

        return Arrays.asList(res.split("#"));



    }
}