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
     * Add an element x to the array. Neglecting the call to resize, this
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
     * Remove the element at index i. Neglecting the call to resize this
     * operation runs in O(n-i)
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

    @SuppressWarnings("ManualArrayToCollectionCopy")
    void resize() {
        T[] b = (T[]) new Object[Math.max(2 * n, 1)];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        a = b;
    }

}
