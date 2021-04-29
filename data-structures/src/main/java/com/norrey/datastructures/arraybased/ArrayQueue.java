/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norrey.datastructures.arraybased;

/**
 *
 * @author Norrey Okumu <okumu.norrey@gmail.com>
 */
public class ArrayQueue<T> {

    private T[] backingArray;
    int j; // index (keeps track of the next element to remove)
    int n; // tracks the number of elements

    public ArrayQueue() {
        backingArray = (T[]) new Object[10];
        n = 0;
        j = 0;
    }

    /**
     * Add element to the queue
     *
     * @param x
     * @return
     */
    public void add(T x) {

        if (n + 1 > this.backingArray.length) {
            resize();
        }

        this.backingArray[(j + n) % this.backingArray.length] = x;
        n++;
    }

    /**
     * Remove first added element
     *
     * @return
     */
    public T remove() {

        if (n == 0) {
            throw new RuntimeException("No such element");
        }

        T x = this.backingArray[this.j];
        this.j = (j + 1) % this.backingArray.length;
        n--;

        return x;
    }

    public int size() {
        return this.n;
    }

    private void resize() {
        int oldLength = this.backingArray.length;
        int newLenghth = oldLength * 2;

        T[] newArray = (T[]) new Object[newLenghth];

        for (int i = 0; i < oldLength; i++) {
            newArray[i] = this.backingArray[i];
        }

        this.backingArray = newArray;
    }

    public void print() {
        for (int i = j; i < n; i++) {
            System.out.println("" + this.backingArray[i]);
        }
    }

}
