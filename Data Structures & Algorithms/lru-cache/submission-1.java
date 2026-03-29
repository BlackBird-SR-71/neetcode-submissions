public class Node {
    int val;
    int key;

    Node next = null;
    Node prev = null;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Map<Integer, Node> cache;
    Node left;
    Node right;
    
    int cap;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.cap = capacity;
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            node.val = value;
            insert(node);
        }
        else {
            Node node = new Node(key, value);
            cache.put(key, node);
            insert(node);
            if (cache.size() > cap) {
                Node lru = left.next;
                remove(lru);
                cache.remove(lru.key);
            }
        }
    }

    private void insert(Node node) {
        Node prv = right.prev;

        prv.next = node;
        node.prev = prv;

        node.next = right;
        right.prev = node;
    }

    private void remove(Node node) {
        Node prv = node.prev;
        Node nxt = node.next;

        prv.next = nxt;
        nxt.prev = prv;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */