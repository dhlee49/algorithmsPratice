class LRUCache {
    private int capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> hashIndex;
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        private Node() {
            this.key = -1;
            this.val = -1;
        }
        private Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.hashIndex = new HashMap();
    }
    
    public int get(int key) {
        if(this.hashIndex.containsKey(key)) {
            Node curr =  this.hashIndex.get(key);
            moveToTail(curr);
            return tail.prev.val;
        }
        return -1;
    }
    public void put(int key, int value) {
        //Case 1 : item already exists. Move item to tail and update value
        if(this.hashIndex.containsKey(key)) {
            Node curr = this.hashIndex.get(key);
            curr.val = value;
            moveToTail(curr);
            return;
        }
        //Case 2 : item is not present but if we reached size limit, remove head.

        Node newNode = new Node(key, value);
        addToTail(newNode);
        this.hashIndex.put(key, newNode);

        if(this.hashIndex.size() > this.capacity) {
            this.hashIndex.remove(this.head.next.key);
            removeNode(this.head.next);
            
        }
    }
    private void moveToTail(Node curr) { 
        removeNode(curr);
        addToTail(curr);
    }
    //Add node to tail
    private void addToTail(Node curr) {
        curr.next = this.tail;
        curr.prev = this.tail.prev;
        this.tail.prev.next = curr;
        this.tail.prev = curr;
    }
    //Function to remove node from the LinkedList
    private void removeNode(Node curr) {
        Node next = curr.next;
        Node prev = curr.prev;
        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */