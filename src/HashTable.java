public class HashTable {
    private static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    private Node[] buckets;
    private int size;

    private static final double LOAD_FACTOR = 0.75;

    public HashTable() {
        buckets = new Node[16];
        size = 0;
    }

    private int hash(int key) {
        return Math.abs(key) % buckets.length;
    }

    public void insert(int key) {
        int index = hash(key);

        Node current = buckets[index];

        while (current != null) {
            if (current.key == key) {
                return;
            }
            current = current.next;
        }

        if ((size + 1.0) / buckets.length > LOAD_FACTOR) {
            resize();
            index = hash(key);
        }

        Node newNode = new Node(key);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }

    private void resize() {
        Node[] oldBuckets = buckets;

        buckets = new Node[oldBuckets.length * 2];

        for (Node head : oldBuckets) {

            Node current = head;

            while (current != null) {

                Node nextNode = current.next;

                int newIndex = hash(current.key);

                current.next = buckets[newIndex];
                buckets[newIndex] = current;

                current = nextNode;
            }
        }
    }

    public boolean contains(int key) {
        int index = hash(key);

        Node current = buckets[index];

        while (current != null) {
            if (current.key == key) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void delete(int key) {
        int index = hash(key);

        Node current = buckets[index];
        Node previous = null;

        while (current != null) {
            if (current.key == key) {
                if (previous == null) {
                    buckets[index] = current.next;
                } else {
                    previous.next = current.next;
                }

                size--;
                return;
            }

            previous = current;
            current = current.next;
        }
    }

    public int size() {
        return size;
    }
}
