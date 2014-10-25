package com.sortations;
/*
    Heap Data Structure implementation using ArrayList for simplicity.
    Methods:
        - can create empty heap and add elements to it.
        - can create heap from existing arrayList.
        - sort method returning arrayList with the sorted elements from the heap.
        - delete method -> left without arguments - delete the biggest
                        -> or give position of element as arg.
        - the otString method is not very explicit but it does the desired visualization.

 */

import java.util.ArrayList;

public class Heap {

    private ArrayList<Integer> heap;
    int length = 0;

    public Heap() {
        heap = new ArrayList();
    }

    public Heap(ArrayList<Integer> arr) {
        heap = new ArrayList(arr);
        length = arr.size();
        buildHeap();
    }

    private void buildHeap() {
        int start = length / 2;
        for (int i = start; i >= 0; i--) {
            moveDown(i);
        }
    }

    public void add(int x) {
        heap.add(x);
        int i = this.length++;
        moveUp(i);
    }

    private void moveUp(int i) {
        while (heap.get(i) > heap.get(parent(i))) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void moveDown(int i) {

        while (heap.get(i) < heap.get(leftChild(i)) || heap.get(i) < heap.get(rightChild(i))) {
            if (heap.get(leftChild(i)) > heap.get(rightChild(i))) {
                swap(i, leftChild(i));
                i = leftChild(i);
            } else {
                swap(i, rightChild(i));
                i = rightChild(i);
            }
        }
    }

    private void heapify(int i) {
        if (heap.get(i) > heap.get(parent(i)))
            moveUp(i);
        else if (heap.get(i) < heap.get(leftChild(i)) || heap.get(i) < heap.get(rightChild(i)))
            moveDown(i);
    }

    public ArrayList<Integer> sort() {
        while (!isEmpty()) {
            delete(0, true);
        }
        return heap;
    }

    public void delete() {
        delete(0, false);
    }

    public void delete(int i) {
        delete(i, false);
    }

    private void delete(int i, boolean sort) {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return;
        }
        swap(i, length - 1);
        length--;
        heapify(i);
        if (!sort)
            heap.remove(length);
    }

    public boolean isEmpty() {
        if (length > 0) {
            return false;
        }
        return true;
    }

    public int length() {
        return this.length;
    }

    private int parent(int i) {
        int r = (i - 1) / 2;
        if (r < 0)
            return 0;
        return r;
    }

    private int leftChild(int i) {
        if (isEmpty()) {
            return i;
        }
        int r = 2 * i + 1;
        if (r >= length) {
            return length - 1;
        }
        return r;
    }

    private int rightChild(int i) {
        if (isEmpty()) {
            return i;
        }
        int r = 2 * i + 2;
        if (r >= length) {
            return length - 1;
        }
        return r;
    }

    public int getMax() {
        if (isEmpty()) {
            System.out.println("Heap Empry");
            return -1;
        }
        return heap.get(0);
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public String toString() {
        int count = 0;
        int del = 1;
        String res = " ";

        for (int x = 0; x < length / 2; x++) {
            System.out.print(" ");
        }

        for (int i = 0; i < this.length; i++) {
            res += heap.get(i) + " ";
            count++;

            if (count % del == 0) {
                res += "\n";
                for (int x = 0; x < length / 2 - i; x++) {
                    res += " ";
                }
                del = del * 2 + 1;
            }
        }
        return res;
    }
}
