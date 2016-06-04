package com.norrey.algorithms.sorting;

/**
 *
 * @author Norrey Okumu <okumu.norrey@gmail.com>
 * @param <T>
 */
public class MergeSort<T extends Comparable<? super T>> {

    private T[] array;
    private T[] tempMergeArray;
    private int n;

    public void sort(final T[] inputArray) {
        this.array = inputArray;
        this.n = inputArray.length;
        this.tempMergeArray = (T[]) new Comparable[n];

        doMergeSort(0, n - 1);
    }

    private void doMergeSort(final int lowerIndex, final int higherIndex) {
        if (lowerIndex >= higherIndex) {
            return;
        }

        int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
        doMergeSort(lowerIndex, middle);
        doMergeSort(middle + 1, higherIndex);
        mergeParts(lowerIndex, middle, higherIndex);
    }

    private void mergeParts(final int lowerIndex, final int middle, final int higherIndex) {
        System.arraycopy(array, 0, tempMergeArray, 0, n);

        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;

        while (i <= middle && j <= higherIndex) {
            if (tempMergeArray[i].compareTo(tempMergeArray[j]) < 0) {
                array[k] = tempMergeArray[i];
                i++;
            } else {
                array[k] = tempMergeArray[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            array[k] = tempMergeArray[i];
            i++;
            k++;
        }

        while (j <= higherIndex) {
            array[k] = tempMergeArray[j];
            j++;
            k++;
        }
    }

    // Test
    public static void main(final String[] args) {
        MergeSort ms = new MergeSort();
        Integer[] inputArray = {9, 5, 4, 6, 10, 7, 8, 1, 2, 3};
        ms.sort(inputArray);

        for (Integer integer : inputArray) {
            System.out.println(integer);
        }
    }

}
