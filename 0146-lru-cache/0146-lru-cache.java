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

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */