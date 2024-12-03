class ListNode{
    int key;
    int value;
    ListNode prev;
    ListNode next;

    public ListNode(int k, int v){
        key = k;
        value = v;
    }
}

class LRUCache {
    HashMap<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    int cacheCapacity;

    public LRUCache(int capacity) {
        this.cacheCapacity = capacity;
        map = new HashMap<>();
        
        head = new ListNode(-1,-1);
        tail =new ListNode(-1,-1);

        head.next= tail;
        tail.prev= head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode n = map.get(key);

            remove(n);
            add(n);

            return n.value;
        }
        else
            return -1;
        
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        
        ListNode n = new ListNode(key,value);
        map.put(key, n);
        add(n);

        if (map.size() > cacheCapacity) {
            ListNode lruNode = head.next;
            remove(lruNode);
            map.remove(lruNode.key);
        }
    }

    public void add(ListNode node){
        ListNode prevEnd = tail.prev;
        prevEnd.next = node;

        node.next = tail;
        tail.prev =node;
        node.prev = prevEnd;
    }

    public void remove(ListNode node){
       node.prev.next = node.next;
       node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */