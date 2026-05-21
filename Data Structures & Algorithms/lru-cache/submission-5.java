public class LRUCache {

    private int cap;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;

    

    public class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        left = null;
        right = null;
        cache = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            detachNode(node);
            addRight(node);
            return node.val;
        } else {
            return -1;
        }
    }

    private void detachNode(Node node) {
        if (left == right) {
            left = null;
            right = null;
            return;
        }
        if (left == node) {
            left.next.prev = null;
            left = left.next;
            node.next = null;
            return;
        }
        if (right == node) {
            right.prev.next = null;
            right = right.prev;
            node.prev = null;
            return;
        }


        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    private void removeLeft() {

    }

    private void addRight(Node node) {
        if (right == null) {
            left = node;
            right = node;
            return;
        }
        right.next = node;
        node.prev = right;
        right = right.next;
    }

    public void put(int key, int value) {
        Node node;
        if (cache.containsKey(key)) {
            node = cache.get(key);
            node.val = value;
            detachNode(node);
        } else {
            node = new Node(key, value);
            if (cache.size() == cap) {
                cache.remove(left.key);
                detachNode(left);
            }
        }

        addRight(node);
        cache.put(key, node);
    }
}
