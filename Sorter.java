package com.sortations;

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
}