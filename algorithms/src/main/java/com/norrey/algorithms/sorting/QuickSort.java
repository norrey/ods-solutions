package com.norrey.algorithms.sorting;

import java.util.Random;

/**
 * This sorts the array in-place;
 *
 * @author Norrey Okumu <okumu.norrey@gmail.com>
 * @param <T>
 */
public class QuickSort<T extends Comparable<? super T>> {

    public void sort(final T[] inputArray) {
        sort(inputArray, 0, inputArray.length);
    }

    private void sort(final T[] inputArray, final int lowerIndex, final int length) {
        if (length <= 1) {
            return;
        }

        final T x = inputArray[lowerIndex + new Random().nextInt(length)]; // Choose a random pivot
        int p = lowerIndex - 1;
        int j = lowerIndex;
        int q = lowerIndex + length;

        while (j < q) {
            final int comp = inputArray[j].compareTo(x);
            if (comp < 0) {
                swap(inputArray, j++, ++p); // move to the beginning of the array
            } else if (comp > 0) {
                swap(inputArray, j, --q); // move to the end of array
            } else {
                j++; // Keep position
            }
        }

        sort(inputArray, lowerIndex, p - lowerIndex + 1);
        sort(inputArray, q, length - (q - lowerIndex));

    }

    private void swap(T[] inputArray, int i, int j) {
        T temp = inputArray[j];
        inputArray[j] = inputArray[i];
        inputArray[i] = temp;
    }

    // Test
    public static void main(final String[] args) {
        QuickSort ms = new QuickSort();
        Integer[] inputArray = {9, 5, 4, 6, 10, 7, 8, 1, 2, 3};
        ms.sort(inputArray);

        for (Integer integer : inputArray) {
            System.out.println(integer);
        }
    }

}
