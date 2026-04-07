class Solution {


    Queue<String> q = new LinkedList<>();
    Set<String> vis = new HashSet<>();
    Set<String> words = new HashSet<>();

    Map<String, List<String>> adj = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for(String str : wordList) {
            words.add(str);
        }
        

        q.offer(beginWord);
        int res = 0;

        while (!q.isEmpty()) {
            res++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String word = q.poll();
                

                if (word.equals(endWord)) {
                    // System.out.println("YES");
                    return res;
                }  
                addAdjacentWords(word);
            }
        }

        return 0;
    }

    private void addAdjacentWords(String word) {
        vis.add(word);
        String temp = word;
        for (int i = 0; i < word.length(); i++) {
            temp = word;
            for (char j = 'a'; j <= 'z'; j++) {
                temp = temp.substring(0, i) + String.valueOf(j) + temp.substring(i + 1);
                if (!vis.contains(temp) && words.contains(temp)) {
                    // System.out.println(word);
                    q.offer(temp);
                }
            }
        }
    }

    
}
 