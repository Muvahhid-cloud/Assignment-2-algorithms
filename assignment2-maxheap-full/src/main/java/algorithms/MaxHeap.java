package algorithms;

public interface MaxHeap {
    void insert(int value);
    int extractMax();
    void increaseKey(int index, int newValue);
    int size();
    boolean isEmpty();
}
