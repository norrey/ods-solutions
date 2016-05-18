package com.norrey.datastructures.arraybased;

/**
 * This is the ArrayStack described in Open Data Structures book
 *
 * @author Norrey Okumu <okumu.norrey@gmail.com>
 * @param <T>
 */
public class ArrayStack<T> {

    T[] a;
    int n;

    /**
     * Initialize this ArrayStack with size 10 and zero elements
     */
    public ArrayStack() {
        a = (T[]) new Object[10];
        n = 0;
    }

    /**
     * Returns the size of this array stack
     *
     * @return
     */
    int size() {
        return n;
    }

    /**
     * This operation takes constant time O(1)
     *
     * @param i
     * @return
     */
    T get(int i) {
        return a[i];
    }

    /**
     * This operation runs in constant time O(1)
     *
     * @param i
     * @param x
     * @return
     */
    T set(int i, T x) {
        T y = a[i];
        a[i] = x;
        return y;
    }

    /**
     * Add an element x to the array. Ignoring the call to resize, this
     * operation runs in O(n-i)
     *
     * @param i
     * @param x
     */
    void add(int i, T x) {
        if (n + 1 > a.length) {
            resize();
        }

        for (int j = n; j > i; j--) {
            a[j] = a[j + 1];
        }
        a[i] = x;
        n++;
    }

    /**
     * Remove the element at index i. Ignoring the call to resize this operation
     * runs in O(n-i)
     *
     * @param i
     * @return
     */
    T remove(int i) {
        T x = a[i];
        for (int j = i; j <= n - 1; j++) {
            a[j] = a[j + 1];
        }
        n--;
        if (a.length > 3 * n) {
            resize();
        }
        return x;
    }

    /**
     * Resizes the array by creating a larger array and copying the contents of
     * the existing into the new array then assigns the new to the old array
     */
    @SuppressWarnings("ManualArrayToCollectionCopy")
    void resize() {
        T[] b = (T[]) new Object[Math.max(2 * n, 1)];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        a = b;
    }

}
