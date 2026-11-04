class Node{
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key,int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    HashMap<Integer,Node> hmap;
    Node head, tail;
    int cap;

    public LRUCache(int capacity) {
        hmap = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        this.cap = capacity;
        head.next = tail;
        tail.prev = head; 
    }
    
    public int get(int key) {
        Node node = hmap.get(key);
        if(node == null){
            return -1;
        }
        remove(node);
        insert(node);
        return node.val;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void insert(Node node){
         node.prev = head;
         node.next = head.next;
         head.next.prev = node;
         head.next = node;
    }
    
    public void put(int key, int value) {
        if(hmap.containsKey(key)){
            remove(hmap.get(key));
        }
        hmap.put(key,new Node(key,value));
        insert(hmap.get(key));
        if(hmap.size() > cap){
            Node lru = tail.prev;
            remove(lru);
            hmap.remove(lru.key);
        }
    }
}
