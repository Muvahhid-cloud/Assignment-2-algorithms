package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaxHeapImplementationTest {

    @Test
    public void testInsertAndExtractMax() {
        MaxHeapImplementation heap = new MaxHeapImplementation();
        heap.insert(10);
        heap.insert(5);
        heap.insert(30);
        heap.insert(20);

        assertEquals(30, heap.extractMax());
        assertEquals(20, heap.extractMax());
        assertEquals(10, heap.extractMax());
        assertEquals(5, heap.extractMax());
    }

    @Test
    public void testIncreaseKey() {
        MaxHeapImplementation heap = new MaxHeapImplementation();
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);

        heap.increaseKey(2, 25);
        assertEquals(25, heap.extractMax());
    }

    @Test
    public void testEmptyHeapThrows() {
        MaxHeapImplementation heap = new MaxHeapImplementation();
        assertThrows(IllegalStateException.class, heap::extractMax);
    }
}
