package algorithms;

import java.util.ArrayList;
import java.util.List;

public class MaxHeapImplementation implements MaxHeap {
    private final List<Integer> heap;
    private int comparisons;
    private int swaps;

    public MaxHeapImplementation() {
        heap = new ArrayList<>();
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
        swaps++;
    }

    @Override
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0 && heap.get(parent(index)) < heap.get(index)) {
            comparisons++;
            swap(index, parent(index));
            index = parent(index);
        }
    }

    @Override
    public int extractMax() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        int max = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return max;
    }

    private void heapifyDown(int index) {
        int largest = index;
        int left = left(index);
        int right = right(index);

        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            comparisons++;
            largest = left;
        }

        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            comparisons++;
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    @Override
    public void increaseKey(int index, int newValue) {
        if (index < 0 || index >= heap.size()) throw new IndexOutOfBoundsException();
        if (newValue < heap.get(index)) throw new IllegalArgumentException("New value is smaller than current value");
        heap.set(index, newValue);
        heapifyUp(index);
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public List<Integer> getHeap() {
        return heap;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }
}
