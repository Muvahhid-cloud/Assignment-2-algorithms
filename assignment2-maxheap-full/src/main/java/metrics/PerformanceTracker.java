package metrics;

public class PerformanceTracker {
    private static long comparisons;
    private static long swaps;

    public static void reset() {
        comparisons = 0;
        swaps = 0;
    }

    public static void recordComparison() {
        comparisons++;
    }

    public static void recordSwap() {
        swaps++;
    }

    public static long getComparisons() {
        return comparisons;
    }

    public static long getSwaps() {
        return swaps;
    }
}
