package com.norrey.algorithms.sorting;

/**
 *
 * @author Norrey Okumu <okumu.norrey@gmail.com>
 */
public class BubbleSort {

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void printArray(int[] array) {
        System.out.println("The array");
        System.out.println("=============");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private int[] sort(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                count++;
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
        
        System.out.println("Number of computations: " + count);
        return array;
    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 9, 5, 8, 7};

        final BubbleSort bubbleSort = new BubbleSort();
        int[] sortedArray = bubbleSort.sort(array);

        printArray(sortedArray);

    }

}
