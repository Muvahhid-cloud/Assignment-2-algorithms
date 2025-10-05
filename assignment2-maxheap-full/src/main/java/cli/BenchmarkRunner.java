package cli;

import algorithms.MaxHeap;
import algorithms.MaxHeapImplementation; // import the implementation
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        // Different input sizes for benchmark
        int[] sizes = {1000, 5000, 10000, 50000, 100000};
        Random rand = new Random();

        // Create output folder if it doesn't exist
        java.io.File outputDir = new java.io.File("docs/performance-plots");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        // Run benchmarks and save to CSV
        try (FileWriter writer = new FileWriter("docs/performance-plots/benchmark_results.csv")) {
            writer.write("Size,InsertTime(ns),ExtractMaxTime(ns)\n");

            for (int n : sizes) {
                int[] data = rand.ints(n, 0, 100000).toArray();

                //  Create heap implementation
                MaxHeap heap = new MaxHeapImplementation();

                // Measure insert time
                long startInsert = System.nanoTime();
                for (int value : data) {
                    heap.insert(value);
                }
                long endInsert = System.nanoTime();

                // Measure extract time
                long startExtract = System.nanoTime();
                while (!heap.isEmpty()) { //  use the new isEmpty() method
                    heap.extractMax();
                }
                long endExtract = System.nanoTime();

                long insertTime = endInsert - startInsert;
                long extractTime = endExtract - startExtract;

                writer.write(n + "," + insertTime + "," + extractTime + "\n");
                System.out.println(" Completed benchmark for size " + n);
            }

            System.out.println("\n Benchmark results saved to: docs/performance-plots/benchmark_results.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
