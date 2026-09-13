import java.util.*;

public class LRUCache {

    private final Map<Integer, Node> map = new HashMap<>();
    private final PriorityQueue<Node> queue = new PriorityQueue<>(
            (a,b) -> Long.compare(a.lastUsed, b.lastUsed)
    );
    private final int capacity;
    private long counter=0;

    static class Node  {
        int value;
        int key;
        long lastUsed;

        Node(int key, int value, long lastUsed) {
            this.key = key;
            this.value = value;
            this.lastUsed = lastUsed;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;

    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node currentNode = map.get(key);
            queue.remove(currentNode);
            currentNode.lastUsed=++counter;
            queue.add(currentNode);

            return currentNode.value;
        }else{
            return -1;
        }

    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node currentNode = map.get(key);
            queue.remove(currentNode);
            currentNode.value = value;
            currentNode.lastUsed=++counter;
            queue.add(currentNode);

            return;
        }

        if(map.size() == capacity){

            Node removal = queue.poll();
            map.remove(removal.key);

        }


        Node node = new Node(key, value, ++counter);
        map.put(key, node);

        queue.add(node);

    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(2, 1);
        cache.put(2, 2);

        System.out.println(cache.get(2));  // Expected: 2

        cache.put(1, 1);
        cache.put(4, 1);

        System.out.println(cache.get(2));  // Expected: -1
    }
}