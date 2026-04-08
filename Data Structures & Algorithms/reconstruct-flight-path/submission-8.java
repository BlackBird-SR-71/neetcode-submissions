class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>((a,b) -> a.compareTo(b))).add(ticket.get(1));
        }

        dfs("JFK");
        Collections.reverse(res);
        return res;

    }


    private void dfs(String dep) {
        
        PriorityQueue<String> adj = map.get(dep);
        while (adj != null && !adj.isEmpty()) {
            dfs(adj.poll());
        }

        res.add(dep);
    }
}
