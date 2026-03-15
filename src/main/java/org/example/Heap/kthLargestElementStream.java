package org.example.Heap;

//Given an input stream of n integers,
// find the kth largest element each time
// when an new element is added to the stream.

import java.util.ArrayList;
import java.util.PriorityQueue;

class kthLargestElementStream {
// Function to print kth largest element for each element in the stream.
public void kthLargest(int arr[], int n, int k) {
    // Your code here
    ArrayList<Integer> result=new ArrayList<Integer>();
    PriorityQueue<Integer> minHeap=new PriorityQueue<>();

    for(int num: arr){
        minHeap.add(num);

        //Keep Only K largest elements
        if(minHeap.size()>k) minHeap.poll();

        if(minHeap.size()<k) result.add(-1);
        else result.add(minHeap.peek());
    }
    for(int i=0;i<arr.length;i++){
        System.out.print(result.get(i)+" ");
    }
}
//DRIVER FUNCTION
public static void main(String[] args) {
    kthLargestElementStream obj = new kthLargestElementStream();

    int[] stream = {10, 20, 11, 70, 50, 40, 100, 5};
    int k = 3;

    System.out.print("Stream: ");
    printArray(stream);

    System.out.println("k = " + k);
    System.out.print("Kth largest at each step: ");
    obj.kthLargest(stream, stream.length, k);
}

public static void printArray(int[] arr) {
    for (int num : arr) System.out.print(num + " ");
    System.out.println();
}

}
