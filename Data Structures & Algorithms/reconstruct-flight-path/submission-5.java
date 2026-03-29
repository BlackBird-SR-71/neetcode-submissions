class Solution {
    Queue<String> q = new LinkedList<>();
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    int edges;

    public List<String> findItinerary(List<List<String>> tickets) {
        edges = tickets.size();
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>((a, b) -> a.compareTo(b))).add(ticket.get(1));
        }

        dfs("JFK");
        Collections.reverse(res);
        return res;
    }

    private void dfs(String node) {
        PriorityQueue<String> adj = map.get(node);

        while (adj != null && !adj.isEmpty()) {
            String next = adj.poll();
            dfs(next);
        }
        res.add(node);
    }
}
