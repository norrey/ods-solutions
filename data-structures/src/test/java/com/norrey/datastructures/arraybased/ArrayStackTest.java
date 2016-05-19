package com.norrey.datastructures.arraybased;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Norrey Okumu <okumu.norrey@gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class ArrayStackTest {

    @Test
    public void testInitialSize() {
        final ArrayStack<String> stack = new ArrayStack();
        int actual = stack.size();
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void testAddToStack() {
        final ArrayStack<String> names = new ArrayStack();
        names.add(0, "Norrey");

        int actual = names.size();
        int expected = 1;

        assertEquals(actual, expected);
    }

    @Test
    public void testSetToStack() {
        final ArrayStack<String> names = new ArrayStack();
        names.add(0, "Norrey");
        names.set(0, "Treasure");

        int actualSize = names.size();
        int expectedSize = 1;

        final String actualName = names.get(0);
        final String expectedName = "Treasure";

        assertEquals(actualName, expectedName);
        assertEquals(actualSize, expectedSize);
    }

    @Test
    public void testRemove() {
        final ArrayStack<String> names = new ArrayStack();
        names.add(0, "Norrey");
        names.add(1, "Christine");

        names.remove(1);
        int actual = names.size();
        int expected = 1;

        String actualName = names.get(0);
        String expectedName = "Norrey";

        assertEquals(actual, expected);
        assertEquals(actualName, expectedName);
    }

}
