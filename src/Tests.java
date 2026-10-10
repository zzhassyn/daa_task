public class Tests {
    public static void main(String[] args) {

        HashTable table = new HashTable();

        table.insert(10);
        table.insert(20);
        table.insert(30);

        System.out.println(table.contains(20));
        System.out.println(table.contains(99));

        table.delete(20);

        System.out.println(table.contains(20));
        System.out.println(table.size());
    }
}