package com.sortations;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void print(int[] array){
        for(int i = 0; i < array.length; i++)
            System.out.printf("%d ", array[i]);
        System.out.println();
    }

    public static void main(String[] args) {

        //HeapTest
        ArrayList<Integer> l = new ArrayList();
        l.add(2);
        l.add(5);
        l.add(-25);
        l.add(55);
        l.add(-2);
        l.add(23);
        Heap h = new Heap(l);
        h.add(1);
        h.add(5);
        h.add(2);
        h.add(3);
        h.add(7);
        h.add(-1);
        h.add(4);
        h.add(3);
        h.add(14);
        h.add(41);
        h.add(45);

        System.out.println(h);
        System.out.printf("Max element: %d\n", h.getMax());

        h.delete();
        System.out.println(h);
        System.out.printf("Max element: %d\n", h.getMax());

        h.delete(1);
        System.out.println(h);
        System.out.printf("Max element: %d\n", h.getMax());

        h.delete();
        System.out.println(h);
        System.out.printf("Max element: %d\n", h.getMax());

        l = h.sort();
        System.out.println(l);
        //End of HeapTest

        System.out.println();

        //SortationsTest
        int maxx = 10;
        int[] array = new int[maxx];
        Random generator = new Random();

        for (int i = 0; i < maxx; i++)
            array[i] = generator.nextInt(maxx);

        int[] arr = new int[maxx];

        int[] masiv = new int[]{0, 2, 6, 3, 2, 7, 8, 33, 1, 4, 5, 10, 9};

        System.arraycopy(array, 0, arr, 0, array.length);
        long startTime = System.nanoTime();
        Sorter.heapSort(arr);
        long endTime = System.nanoTime();
        double duration = (double)(endTime - startTime);
        System.out.printf("heap sort: %f\n", duration/1000000 );

        System.arraycopy(array, 0, arr, 0, array.length);
        startTime = System.nanoTime();
        Sorter.mergeSort(arr);
        endTime = System.nanoTime();
        duration = (double)(endTime - startTime);
        System.out.printf("merge sort: %f\n", duration/1000000 );

        System.arraycopy(array, 0, arr, 0, array.length);
        startTime = System.nanoTime();
        Sorter.quickSort(arr);
        endTime = System.nanoTime();
        duration = (double)(endTime - startTime);
        System.out.printf("quick sort: %f\n", duration/1000000 );

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

        System.arraycopy(array, 0, arr, 0, array.length);
        startTime = System.nanoTime();
        Sorter.bubbleSort(arr);
        endTime = System.nanoTime();
        duration = (double)(endTime - startTime);
        System.out.printf("bubble sort: %f\n", duration/1000000 );
    }
}
