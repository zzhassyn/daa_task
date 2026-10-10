import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Benchmark {

    private static final int[] SIZES = {
            100, 1000, 10000
    };

    private static final int RUNS = 5;
    private static final long SEED = 42;

    public static void main(String[] args) throws IOException {

        new File("results").mkdirs();

        PrintWriter writer = new PrintWriter(
                new FileWriter("results/results.csv"));

        writer.println(
                "n,structure,operation,averageTimeNs");

        for (int n : SIZES) {

            int[] values = generateUniqueRandomValues(n);

            benchmarkBST(writer, n, values);
            benchmarkHashTable(writer, n, values);

            System.out.println("n = " + n + " finished");
        }

        writer.close();

        System.out.println("Benchmark finished.");
    }

    private static void benchmarkBST(
            PrintWriter writer,
            int n,
            int[] values) {

        long insertTotal = 0;
        long searchTotal = 0;
        long deleteTotal = 0;

        for (int run = 0; run < RUNS; run++) {

            // INSERT
            BST bst = new BST();

            long start = System.nanoTime();

            for (int value : values) {
                bst.insert(value);
            }

            long end = System.nanoTime();

            insertTotal += end - start;

            // SEARCH
            start = System.nanoTime();

            for (int value : values) {
                bst.contains(value);
            }

            end = System.nanoTime();

            searchTotal += end - start;

            // DELETE
            start = System.nanoTime();

            for (int value : values) {
                bst.delete(value);
            }

            end = System.nanoTime();

            deleteTotal += end - start;
        }

        writer.println(
                n + ",BST,insert,"
                        + (insertTotal / RUNS));

        writer.println(
                n + ",BST,search,"
                        + (searchTotal / RUNS));

        writer.println(
                n + ",BST,delete,"
                        + (deleteTotal / RUNS));
    }

    private static void benchmarkHashTable(
            PrintWriter writer,
            int n,
            int[] values) {

        long insertTotal = 0;
        long searchTotal = 0;
        long deleteTotal = 0;

        for (int run = 0; run < RUNS; run++) {

            // INSERT
            HashTable table = new HashTable();

            long start = System.nanoTime();

            for (int value : values) {
                table.insert(value);
            }

            long end = System.nanoTime();

            insertTotal += end - start;

            // SEARCH
            start = System.nanoTime();

            for (int value : values) {
                table.contains(value);
            }

            end = System.nanoTime();

            searchTotal += end - start;

            // DELETE
            start = System.nanoTime();

            for (int value : values) {
                table.delete(value);
            }

            end = System.nanoTime();

            deleteTotal += end - start;
        }

        writer.println(
                n + ",HashTable,insert,"
                        + (insertTotal / RUNS));

        writer.println(
                n + ",HashTable,search,"
                        + (searchTotal / RUNS));

        writer.println(
                n + ",HashTable,delete,"
                        + (deleteTotal / RUNS));
    }

    private static int[] generateUniqueRandomValues(int n) {

        Random random = new Random(SEED);

        int[] values = new int[n];

        java.util.HashSet<Integer> used = new java.util.HashSet<>();

        int index = 0;

        while (index < n) {
            int value = random.nextInt(n * 10);

            if (used.add(value)) {
                values[index] = value;
                index++;
            }
        }

        return values;
    }
}