package com.sortations;

import java.util.ArrayList;
import java.util.Random;

public class Main {

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
        h.delete();
        h.sort();
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
        Integer[] arr = new Integer[maxx];
        Random generator = new Random();

        Heap hTestSort = new Heap();
        for (int i = 0; i < maxx; i++) {
            arr[i] = generator.nextInt(maxx);
            hTestSort.add(arr[i]);
        }

        Sorter sort = new Sorter(arr);

        sort.printArray();
        long startTime = System.nanoTime();
        sort.heapSort();
        long endTime = System.nanoTime();
        double duration = (double)(endTime - startTime);
        System.out.printf("heap sort: %f\n", duration/1000000 );
        sort.printArray();

        startTime = System.nanoTime();
        hTestSort.sort();
        endTime = System.nanoTime();
        duration = (double)(endTime - startTime);
        System.out.printf("heap Struct sort: %f\n", duration/1000000 );

        System.out.print("Shuffle: ");
        sort.shuffle();
        sort.printArray();
        startTime = System.nanoTime();
        sort.mergeSort();
        endTime = System.nanoTime();
        duration = (double)(endTime - startTime);
        System.out.printf("merge sort: %f\n", duration/1000000 );
        sort.printArray();

        System.out.print("Shuffle: ");
        sort.shuffle();
        sort.printArray();
        startTime = System.nanoTime();
        sort.quickSort();
        endTime = System.nanoTime();
        duration = (double)(endTime - startTime);
        System.out.printf("quick sort: %f\n", duration/1000000 );
        sort.printArray();

        System.out.print("Shuffle: ");
        sort.shuffle();
        sort.printArray();
        startTime = System.nanoTime();
        sort.insertionSort();
        endTime = System.nanoTime();
        duration = (double)(endTime - startTime);
        System.out.printf("insertion sort: %f\n", duration/1000000 );
        sort.printArray();

        System.out.print("Shuffle: ");
        sort.shuffle();
        sort.printArray();
        startTime = System.nanoTime();
        sort.selectionSort();
        endTime = System.nanoTime();
        duration = (double)(endTime - startTime);
        System.out.printf("selection sort: %f\n", duration/1000000 );
        sort.printArray();

        //System.arraycopy(array, 0, arr, 0, array.length);
        System.out.print("Shuffle: ");
        sort.shuffle();
        sort.printArray();
        startTime = System.nanoTime();
        sort.bubbleSort();
        endTime = System.nanoTime();
        duration = (double)(endTime - startTime);
        System.out.printf("bubble sort: %f\n", duration/1000000 );
        sort.printArray();
    }
}
