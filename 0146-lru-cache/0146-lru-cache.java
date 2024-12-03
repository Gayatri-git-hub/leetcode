//Using Build in Java Data Structure LinkedHashMap. LinkedHashMap<>(capacity, 100.00f, true)
// True - if we want to order the list by recent access 
// False - if we want to order based on inserts. 
/*
class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    int cacheCapacity;

    public LRUCache(int capacity) {
        this.cacheCapacity = capacity;
        cache = new LinkedHashMap<>(capacity, 100.00f, true){
            @Override
            public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
                return size() > cacheCapacity;
            }
        };
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) return cache.get(key);
        else return -1;
        
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
    }
}
*/

//Using Doubly Linked List 
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
    HashMap<Integer, ListNode> cache;
    ListNode head;
    ListNode tail;
    int maxCapacity; 

    public LRUCache(int capacity) {
        maxCapacity = capacity;
        cache = new HashMap<>();

        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);

        head.next = tail;
        tail.prev = head;
    }
    
    private void add(ListNode n){
        ListNode tailPrev = tail.prev;

        tailPrev.next = n;
        n.next = tail;
        tail.prev = n;
        n.prev = tailPrev; 
    }

    private void remove(ListNode n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    public int get(int key) {

        if(!cache.containsKey(key)) return -1;

        ListNode n = cache.get(key);
        remove(n);
        add(n);
        return n.value;
        
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)){
            ListNode n = cache.get(key);
            remove(n);
        }
        ListNode n = new ListNode(key, value);
        cache.put(key, n);
        add(n);

        if(cache.size() > maxCapacity){
            ListNode evictNode = head.next;
            remove(evictNode);
            cache.remove(evictNode.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */