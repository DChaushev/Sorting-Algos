package com.sortations;

import java.util.Random;

public class Sorter<T extends Comparable<? super T>> {

    private T[] array;
    private int numberOfElements;

    public Sorter(T[] inputArray){
        numberOfElements = inputArray.length;
        setArray(inputArray);
    }

    private void setArray(T[] inputArray){
        array = (T[])java.lang.reflect.Array
                .newInstance(inputArray.getClass().getComponentType(), numberOfElements);
        for (int i = 0; i < inputArray.length; i++)
            array[i] = inputArray[i];
    }

    private void swap(int i, int j){
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

//    public void bubbleSort(int[] array){
//        bubbleSort(array, array.length);
//    }

    public void bubbleSort(){

        int n = array.length;

        while( n != 0 ){
            int newN = 0;
            for (int i = 1; i < n; i++){
                if(array[i-1].compareTo(array[i]) > 0){
                    swap(i-1, i);
                    newN = i;
                }
            }
            n = newN;
        }
    }

//    public static void insertionSort(int[] array){
//        insertionSort(array, array.length);
//    }
//
    public void insertionSort(){
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

//    public static void selectionSort(int array[]){
//        selectionSort(array, array.length);
//    }

    public void selectionSort(){
        for (int j = 0; j < numberOfElements - 1; j++)
        {
            int iMin = j;
            for (int i = j + 1; i < numberOfElements; i++)
                if(array[i].compareTo(array[iMin]) < 0)
                    iMin = i;
            if (iMin != j)
                swap(j, iMin);
        }
    }

    public void quickSort(){
        quickSort(0, numberOfElements - 1);
    }

    private int partition(int left, int right){
        int pivotIndex = (left + right)/2;
        T pivotValue = array[pivotIndex];
        swap(pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i <= right; i++)
            if(array[i].compareTo(pivotValue) < 0){
                swap(i, storeIndex);
                storeIndex++;
            }
        swap(storeIndex, right);
        return  storeIndex;
    }

    private void quickSort(int left, int right){
        if (left < right){
            int p = partition(left, right);
            quickSort(left, p - 1);
            quickSort(p + 1, right);
        }
    }

    private void siftDown(int start, int end){
        int root = start;

        while (root * 2 + 1 <= end){
            int child = root * 2 + 1;
            int swapI = root;

            if (array[swapI].compareTo(array[child]) < 0)
                swapI = child;
            if (child + 1 <= end && array[swapI].compareTo(array[child + 1]) < 0)
                swapI = child + 1;
            if (swapI != root){
                swap(root, swapI);
                root = swapI;
            }
            else
                return;
        }
    }


    private void heapify(){
        int start = ((numberOfElements - 2) / 2);

        while (start >= 0){
            siftDown(start, numberOfElements - 1);
            start--;
        }
    }

//    public static void heapSort(int array[]){
//        heapSort(array, array.length);
//    }

    public void heapSort(){

        heapify();

        int end = numberOfElements - 1;

        while (end > 0){
            swap(end, 0);
            end--;
            siftDown(0, end);
        }
    }


    public void mergeSort(){
        T[] temp = ((T[])java.lang.reflect.Array
                .newInstance(array.getClass().getComponentType(), numberOfElements));
        mergeSort(0, array.length - 1, temp);
    }

    private void merge(int start, int middle, int end, T temp[]) {

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

    private void mergeSort(int start, int end, T temp[]){
        if (start < end) {
            int middle = start + (end - start) / 2;
            mergeSort(start, middle, temp);
            mergeSort(middle + 1, end, temp);
            merge(start, middle, end, temp);
        }
    }

    public void shuffle(){
        Random rand = new Random();
        for (int i = 0; i < numberOfElements; i++){
            int newPos = rand.nextInt(numberOfElements);
            swap(i, newPos);
        }
    }

    public void printArray(){
        for (T element : array)
            System.out.printf("%s ", element);
        System.out.println();
    }
}
