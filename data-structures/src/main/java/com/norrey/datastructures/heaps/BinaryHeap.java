package com.norrey.datastructures.heaps;

/**
 *
 * @author Norrey Okumu <okumu.norrey@gmail.com>
 * @param <T>
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    T[] a;
    int n;

    public BinaryHeap() {
        a = (T[]) new Comparable[10];
        n = 0;
    }

    int size() {
        return n;
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    boolean add(T x) {
        if (n + 1 > a.length) {
            resize();
        }
        a[n++] = x;
        bubbleUp(n - 1);
        return true;
    }

    /**
     * Removes the smallest value from the heap
     *
     * @return
     */
    T remove() {
        /*
         * The smallest value is the root at the first location in the array
         */
        T x = a[0];
        /*
         * Replace the root element witht the element at n-1 and then delete it
         * and decrement the heap
         */
        a[0] = a[--n];
        trickleDown(0);
        if (a.length > 3 * n) {
            resize();
        }
        return x;
    }

    /**
     * Ensures any of the children after add is not less that its parent
     *
     * @param i
     */
    void bubbleUp(int i) {
        int p = parent(i);
        while (i > 0 && a[i].compareTo(a[p]) < 0) {
            swap(i, p);
            i = p;
            p = parent(i);
        }
    }

    /**
     * Ensures that the smallest element of the remaining elements is at index 0
     *
     * @param i
     */
    void trickleDown(int i) {

        do {
            int j = -1;
            int r = right(i);
            if (r < n && a[r].compareTo(a[i]) < 0) {
                int l = left(i);
                if (a[i].compareTo(a[r]) < 0) {
                    j = l;
                } else {
                    j = r;
                }
            } else {
                int l = left(i);
                if (l < n && a[l].compareTo(a[i]) < 0) {
                    j = l;
                }
            }

            if (j >= 0) {
                swap(i, j);
            }

            i = j;

        } while (i >= 0);

    }

    /**
     * Resize the array
     */
    void resize() {
        T[] y = (T[]) new Comparable[Math.max(2 * n, 1)];
        for (int i = 0; i < n; i++) {
            y[i] = a[i];
        }
        a = y;
    }

    /**
     * Swap the elements at index i and j
     *
     * @param i
     * @param j
     */
    void swap(int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
