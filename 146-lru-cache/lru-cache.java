class LRUCache {
    class Node {
        int val;
        int key;
        Node next;
        Node prev;
        public Node (int key, int val) {
            this.key = key;
            this.val = val;
            next = null;
            prev = null;
        }
    }
    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> cache;
    List<Node> entries = new LinkedList<Node>(); 
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.cache = new HashMap<>();
    }
    
    public int get(int key) {
        if(!this.cache.containsKey(key)) return -1;
        Node curr = this.cache.get(key); 
        removeNode(curr);
        putAtTail(curr);
        return curr.val;
    }
    
    public void put(int key, int value) {
        if(this.cache.containsKey(key)) {
            Node curr = this.cache.get(key);
            curr.val = value;
            removeNode(curr);
            putAtTail(curr);
            return;
        }
        Node curr = new Node(key, value);
        putAtTail(curr);
        this.cache.put(key, curr);
        if(this.cache.size() > this.capacity) {
            int removedKey = this.head.next.key;
            removeNode(this.head.next);
            this.cache.remove(removedKey);
        }
    }
    private void putAtTail(Node newNode) {
        Node prev = this.tail.prev;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = this.tail;
        this.tail.prev = newNode;
    }


    private void removeNode(Node curr) {
        Node prev = curr.prev;
        prev.next = curr.next;
        curr.next.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */