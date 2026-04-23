class LRUCache {

    class Node {
        int val;
        int key;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node front;
    Node back;
    int capacity;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.front = new Node(-1,-1);
        this.back = new Node(-1,-1);
        this.map = new HashMap<>();

        front.next = back;
        back.prev = front;
    }

    public void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(int key) {
        Node node = map.get(key);
        back.prev.next = node;
        node.prev = back.prev;
        node.next = back;
        back.prev = node;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        delete(map.get(key));
        insert(key);

        print("get");
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            delete(map.get(key));
            map.remove(key);
        }
        if (map.size() >= capacity) {
            map.remove(front.next.key);
            delete(front.next);
        } 
        map.put(key, new Node(key,value));
        insert(key);

        print("put");
    }

    public void print(String input) {
        System.out.println("After" + input);
        Node cur = front;
        while (cur!=null) {
            System.out.printf("%d.", cur.val);
            cur = cur.next;
        }
        System.out.println();
    }
}
