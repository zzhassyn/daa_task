public class Tests {
    public static void main(String[] args) {
        testBST();
        testHashTable();

        System.out.println("Finish");
    }

    private static void testBST() {
        System.out.println("Testing BST");

        BST bst = new BST();

        check(bst.size() == 0, "BST should be empty");

        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);

        check(bst.contains(8), "BST contains root");
        check(bst.contains(6), "BST contains existing value");
        check(!bst.contains(99), "BST does not contain missing value");

        int beforeDuplicate = bst.size();
        bst.insert(6);
        check(bst.size() == beforeDuplicate, "BST duplicate should not increase size");

        bst.delete(1);
        check(!bst.contains(1), "BST delete leaf");

        bst.delete(3);
        check(!bst.contains(3), "BST delete node");

        System.out.println("BST PASSED");
    }

    private static void testHashTable() {
        System.out.println("Testing HashTable");

        HashTable table = new HashTable();

        check(table.size() == 0, "HashTable should be empty");

        table.insert(10);
        table.insert(20);
        table.insert(30);

        check(table.contains(10), "HashTable contains value");
        check(table.contains(20), "HashTable contains value");
        check(!table.contains(99), "HashTable missing value");

        int beforeDuplicate = table.size();
        table.insert(20);
        check(table.size() == beforeDuplicate,
                "HashTable duplicate should not increase size");

        table.delete(20);
        check(!table.contains(20), "HashTable delete");

        System.out.println("HashTable PASSED");
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError("FAILED: " + message);
        }
    }
}