class LRUCache {
    private Node head;
    private Node tail;
    private int capacity;
    private HashMap<Integer, Node> cache;
    class Node {
        Node prev;
        Node next;
        int val;
        int key;
        public Node(int key, int value) {
            this.key = key;
            this.val = value;
        };
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.cache = new HashMap();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node curr = cache.get(key);
        removeNode(curr);
        addToTail(curr);
        return curr.val;
    }
    private void removeNode(Node target) {
        Node prev = target.prev;
        Node next = target.next;
        prev.next = next;
        next.prev = prev;
    }
    private void addToTail(Node target) {
        Node prev = this.tail.prev;
        target.next = this.tail;
        target.prev = prev;
        prev.next = target;
        this.tail.prev = target;
    }
    public void put(int key, int value) {
        //Case 1 already exists
        if(cache.containsKey(key)) {
            Node curr = cache.get(key);
            removeNode(curr);
            addToTail(curr);
            curr.val = value;
            return;
        }
        //Case 2 not in it
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addToTail(newNode);
        if(cache.size() > this.capacity) {
            cache.remove(this.head.next.key);
            removeNode(this.head.next);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */