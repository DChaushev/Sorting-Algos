package com.sortations;

import java.lang.reflect.Array;

public class Sorter {

    private static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void bubbleSort(int[] array){
        bubbleSort(array, array.length);
    }

    public static void bubbleSort(int[] array, int numberOfElements){

        int n = numberOfElements;

        while( n != 0 ){
            int newN = 0;
            for (int i = 1; i < n; i++){
                if(array[i-1] > array[i]){
                    swap(array, i-1, i);
                    newN = i;
                }
            }
            n = newN;
        }
    }

    public static void insertionSort(int[] array){
        insertionSort(array, array.length);
    }

    public static void insertionSort(int[] array, int numberOfElements){
        for(int i = 1; i < numberOfElements; i++){
            int x = array[i];
            int j = i;
            while(j > 0 && array[j-1] > x){
                array[j] = array[j-1];
                j--;
            }
            array[j] = x;
        }
    }

    public static void selectionSort(int array[]){
        selectionSort(array, array.length);
    }

    public static void selectionSort(int array[], int numberOfElements){
        for (int j = 0; j < numberOfElements - 1; j++)
        {
            int iMin = j;
            for (int i = j + 1; i < numberOfElements; i++)
                if(array[i] < array[iMin])
                    iMin = i;
            if (iMin != j)
                swap(array, j, iMin);
        }
    }

    public static void quickSort(int array[]){
        quickSort(array, 0, array.length - 1);
    }

    public static int partition(int[] array, int left, int right){
        int pivotIndex = (left + right)/2;
        int pivotValue = array[pivotIndex];
        swap(array, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i <= right; i++)
            if(array[i] < pivotValue){
                swap(array, i, storeIndex);
                storeIndex++;
            }
        swap(array, storeIndex, right);
        return  storeIndex;
    }

    public static void quickSort(int array[], int left, int right){
        if (left < right){
            int p = partition(array, left, right);
            quickSort(array, left, p - 1);
            quickSort(array, p + 1, right);
        }
    }

    public static void siftDown(int array[], int start, int end){
        int root = start;

        while (root * 2 + 1 <= end){
            int child = root * 2 + 1;
            int swapI = root;

            if (array[swapI] < array[child])
                swapI = child;
            if (child + 1 <= end && array[swapI] < array[child + 1])
                swapI = child + 1;
            if (swapI != root){
                swap(array, root, swapI);
                root = swapI;
            }
            else
                return;
        }
    }


    public static void heapify(int array[], int numberOfElements){
        int start = ((numberOfElements - 2) / 2);

        while (start >= 0){
            siftDown(array, start, numberOfElements - 1);
            start--;
        }
    }

    public static void heapSort(int array[]){
        heapSort(array, array.length);
    }

    public static void heapSort(int array[], int numberOfElements){

        heapify(array, numberOfElements);

        int end = numberOfElements - 1;

        while (end > 0){
            swap(array, end, 0);
            end--;
            siftDown(array, 0, end);
        }
    }


    public static void mergeSort(int array[]){
        int temp[] = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
    }

    public static void merge(int array[], int start, int middle, int end, int temp[]) {

        for (int i = start; i <= end; i++) {
            temp[i] = array[i];
        }
        int i = start;
        int j = middle + 1;
        int k = start;
        while (i <= middle && j <= end) {
            if (temp[i] <= temp[j]) {
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

    private static void mergeSort(int array[], int start, int end, int temp[]){
        if (start < end) {
            int middle = start + (end - start) / 2;
            mergeSort(array, start, middle, temp);
            mergeSort(array, middle + 1, end, temp);
            merge(array, start, middle, end, temp);
        }
    }
}
