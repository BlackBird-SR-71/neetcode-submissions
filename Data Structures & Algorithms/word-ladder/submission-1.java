class Solution {
    Map<String, List<String>> map = new HashMap<>();
    Set<String> vis = new HashSet<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                map.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
            vis.add(word);
        }

        if (!vis.contains(endWord)) return 0;

        vis = new HashSet<>();

        Queue<String> q = new LinkedList<>();
        int res = 1;
        q.add(beginWord);

        while (!q.isEmpty()) {
            
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return res;
                }

                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    for (String adj : map.getOrDefault(pattern, new ArrayList<>())) {
                        if (!vis.contains(adj)) {
                            q.add(adj);
                            vis.add(adj);
                        }
                        
                    }
                }
                
            }
            res++;
        }
        return 0;


    }
}
