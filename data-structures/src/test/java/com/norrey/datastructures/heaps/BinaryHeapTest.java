package com.norrey.datastructures.heaps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Norrey Okumu <okumu.norrey@gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class BinaryHeapTest {

    @Test
    public void testInitialSize() {
        final BinaryHeap<Integer> heap = new BinaryHeap<>();
        int actualSize = heap.size();
        int expectedSize = 0;

        assertEquals(actualSize, expectedSize);
    }

    @Test
    public void testAdd() {
        final BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(1);
        int actualSize = heap.size();
        int expectedSize = 1;

        assertEquals(actualSize, expectedSize);
    }

    @Test
    public void testRemove() {
        final BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(1);
        heap.add(2);
        heap.remove();
        int actualSize = heap.size();
        int expectedSize = 1;

        assertEquals(actualSize, expectedSize);
    }
    
    @Test
    public void testRemovedElement() {
        final BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(1);
        heap.add(2);
        int actualRemoved = heap.remove();
        int expectedRemoved = 1;

        assertEquals(actualRemoved, expectedRemoved);
    }

}
