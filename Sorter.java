package com.sortations;

import java.util.Random;

public class Sorter {

    private static <T extends Comparable<? super T>> void swap(T[] array, int i, int j){
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    public static <T extends Comparable<? super T>> void bubbleSort(T[] array){

        int n = array.length;

        while( n != 0 ){
            int newN = 0;
            for (int i = 1; i < n; i++){
                if(array[i-1].compareTo(array[i]) > 0){
                    swap(array, i-1, i);
                    newN = i;
                }
            }
            n = newN;
        }
    }


    public static <T extends Comparable<? super T>> void insertionSort(T[] array){
        int numberOfElements = array.length;
        for(int i = 1; i < numberOfElements; i++){
            T x = array[i];
            int j = i;
            while(j > 0 && array[j-1].compareTo(x) > 0){
                array[j] = array[j-1];
                j--;
            }
            array[j] = x;
        }
    }


    public static <T extends Comparable<? super T>> void selectionSort(T[] array){
        int numberOfElements = array.length;
        for (int j = 0; j < numberOfElements - 1; j++)
        {
            int iMin = j;
            for (int i = j + 1; i < numberOfElements; i++)
                if(array[i].compareTo(array[iMin]) < 0)
                    iMin = i;
            if (iMin != j)
                swap(array, j, iMin);
        }
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] array){
        int numberOfElements = array.length;
        quickSort(array, 0, numberOfElements - 1);
    }

    private static <T extends Comparable<? super T>> int partition(T[] array, int left, int right){
        int pivotIndex = (left + right)/2;
        T pivotValue = array[pivotIndex];
        swap(array, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i <= right; i++)
            if(array[i].compareTo(pivotValue) < 0){
                swap(array, i, storeIndex);
                storeIndex++;
            }
        swap(array, storeIndex, right);
        return  storeIndex;
    }

    private static <T extends Comparable<? super T>> void quickSort(T[] array, int left, int right){
        if (left < right){
            int p = partition(array, left, right);
            quickSort(array, left, p - 1);
            quickSort(array, p + 1, right);
        }
    }

    private static <T extends Comparable<? super T>> void siftDown(T[] array, int start, int end){
        int root = start;

        while (root * 2 + 1 <= end){
            int child = root * 2 + 1;
            int swapI = root;

            if (array[swapI].compareTo(array[child]) < 0)
                swapI = child;
            if (child + 1 <= end && array[swapI].compareTo(array[child + 1]) < 0)
                swapI = child + 1;
            if (swapI != root){
                swap(array, root, swapI);
                root = swapI;
            }
            else
                return;
        }
    }


    private static <T extends Comparable<? super T>> void heapify(T[] array){
        int numberOfElements = array.length;
        int start = ((numberOfElements - 2) / 2);

        while (start >= 0){
            siftDown(array, start, numberOfElements - 1);
            start--;
        }
    }


    public static <T extends Comparable<? super T>> void heapSort(T[] array){

        int numberOfElements = array.length;
        heapify(array);

        int end = numberOfElements - 1;

        while (end > 0){
            swap(array, end, 0);
            end--;
            siftDown(array, 0, end);
        }
    }


    public static <T extends Comparable<? super T>> void mergeSort(T[] array){
        int numberOfElements = array.length;
        //do not do this at home
        T[] temp = ((T[])java.lang.reflect.Array
                .newInstance(array.getClass().getComponentType(), numberOfElements));
        mergeSort(array, 0, array.length - 1, temp);
    }

    private static <T extends Comparable<? super T>> void merge(T[] array, int start, int middle, int end, T temp[]) {

        for (int i = start; i <= end; i++) {
            temp[i] = array[i];
        }
        int i = start;
        int j = middle + 1;
        int k = start;
        while (i <= middle && j <= end) {
            if (temp[i].compareTo(temp[j]) <= 0) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = temp[i];
            k++;
            i++;
        }
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] array, int start, int end, T temp[]){
        if (start < end) {
            int middle = start + (end - start) / 2;
            mergeSort(array, start, middle, temp);
            mergeSort(array, middle + 1, end, temp);
            merge(array, start, middle, end, temp);
        }
    }

    public static <T extends Comparable<? super T>> void shuffle(T[] array){
        int numberOfElements = array.length;
        Random rand = new Random();
        for (int i = 0; i < numberOfElements; i++){
            int newPos = rand.nextInt(numberOfElements);
            swap(array, i, newPos);
        }
    }

    public static <T extends Comparable<? super T>>  void printArray(T[] array){
        for (T element : array)
            System.out.printf("%s ", element);
        System.out.println();
    }
}
