package com.norrey.chapter.one;

import java.util.Stack;

/**
 * A Dyck word is a sequence of +1's and -1's with the property that the sum of
 * any prefix of the sequence is never negative. For example, +1, -1, +1, -1 is
 * a Dyck word, but +1, -1, -1, +1 is not a Dyck word. Describe any relationship
 * between Dyck words and Stack push(x) and pop() operations.
 *
 * @author Norrey Okumu <okumu.norrey@gmail.com>
 */
public class Exercise1_2 {

    final Stack<Integer> integers = new Stack<>();

    /**
     * A dyck-ish operation on the stack processes all arguments
     */
    public void testDyck() {
        integers.push(1);
        integers.pop();
        integers.push(1);
        integers.pop();
        integers.push(1);
        integers.pop();
        System.out.println("Operation successfull");
    }

    /**
     * A non-dyck-ish operation on the stack throws an EmptyStackException
     */
    public void testNonDyck() {
        integers.push(1);
        integers.pop();
        integers.pop();
        System.out.println(" The operation cannot proceed from here");
        integers.push(1);
        integers.push(1);
        integers.pop();
    }

    public static void main(final String[] args) {
        final Exercise1_2 dyck = new Exercise1_2();
        /*
         * This processes without an exception
         */
        dyck.testDyck();
        /*
         * This throws an EmptyStackException
         */
        dyck.testNonDyck();

    }

}
