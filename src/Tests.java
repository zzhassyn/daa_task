public class Tests {
    public static void main(String[] args) {

        BST bst = new BST();

        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);

        System.out.println(bst.contains(6));
        System.out.println(bst.contains(99));

        bst.delete(3);

        System.out.println(bst.contains(3));
        System.out.println(bst.size());
    }
}