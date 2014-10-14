package com.sortations;

import java.util.Random;

public class Main {

    public static void print(int[] array){
        for(int i = 0; i < array.length; i++)
            System.out.printf("%d ", array[i]);
        System.out.println();
    }

    public static void main(String[] args) {

        int maxx = 10000;
        int[] array = new int[maxx];
        Random generator = new Random();

        for (int i = 0; i < maxx; i++)
            array[i] = generator.nextInt(maxx);

        int[] arr = new int[maxx];

        System.arraycopy(array, 0, arr, 0, array.length);
        long startTime = System.nanoTime();
        Sorter.quickSort(arr);
        long endTime = System.nanoTime();
        double duration = (double)(endTime - startTime);
        System.out.printf("quick sort: %f\n", duration/1000000 );

        System.arraycopy(array, 0, arr, 0, array.length);
        startTime = System.nanoTime();
        Sorter.bubbleSort(arr);
        endTime = System.nanoTime();
        duration = (double)(endTime - startTime);
        System.out.printf("bubble sort: %f\n", duration/1000000 );

        System.arraycopy(array, 0, arr, 0, array.length);
        startTime = System.nanoTime();
        Sorter.insertionSort(arr);
        endTime = System.nanoTime();
        duration = (double)(endTime - startTime);
        System.out.printf("insertion sort: %f\n", duration/1000000 );

        System.arraycopy(array, 0, arr, 0, array.length);
        startTime = System.nanoTime();
        Sorter.selectionSort(arr);
        endTime = System.nanoTime();
        duration = (double)(endTime - startTime);
        System.out.printf("selection sort: %f\n", duration/1000000 );

    }
}
