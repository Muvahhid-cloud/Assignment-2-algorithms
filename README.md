# Assignment 2 – Max-Heap Implementation

This project demonstrates the implementation of a Max-Heap data structure in Java.
A Max-Heap is a complete binary tree where each parent node is greater than or equal to its children.
It is widely used in priority queues, heap sort, and graph algorithms like Dijkstra’s shortest path.

This assignment also includes performance benchmarking to analyze the time complexity of heap operations and visualize their behavior with Python-generated plots.

## Features
- `insert()` – Adds elements while maintaining the max-heap property
- `extractMax()` – Removes and returns the largest element
- `increaseKey()` – Increases the value of a node and restores heap order
- Efficient heap operations with performance measurement
- Automated benchmarking with data visualization (CSV + PNG)

## Project Structure
```
assignment2-maxheap-full/
│
├── docs/
│   └── performance-plots/
│       ├── benchmark_results.csv        # Generated benchmark data
│       └── performance_plot.png         # Execution time visualization
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── algorithms/
│   │   │   │   ├── MaxHeap.java
│   │   │   │   └── MaxHeapImplementation.java
│   │   │   └── cli/
│   │   │       └── BenchmarkRunner.java
│   │   └── metrics/
│   │       └── PerfermanceTracker
│   │
│   └── test/
│       └── java/
│           └── algorithms/
│               └── MaxHeapImplementationTest.java
│
├── README.md                           # Project documentation
└── pom.xml                             # Build configuration

```

## How to Run
1. Build with Maven:
   ```bash
   mvn clean package
   ```
2. Run benchmarks:
   ```bash
   java -cp target/maxheap-1.0.jar cli.BenchmarkRunner
   ```

  **This will create the file:**
  ```bash
    docs/performance-plots/benchmark_results.csv
```
## Analysis

The benchmark results confirm that:

- Heap insertion and extraction grow approximately at O(log n) per operation.
- For larger input sizes, total execution time scales linearly with the number of operations.
- This matches the expected theoretical performance of a Max-Heap.

## Author

- Zainiddin Tursunaliev
Assignment 2 – Data Structures & Algorithms
