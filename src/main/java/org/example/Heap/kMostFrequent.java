package org.example.Heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;


//Given an array arr[] in which elements may be repeating several times. Also, a positive number k is given and the task is to find sum of total frequencies of k most occurring elements.
//        Note: The value of k is guaranteed to be less than or equal to the number of distinct elements in arr.

public class kMostFrequent {
    // Function to print the sum of frequencies of k numbers
    // with most occurrences in an array.
    int kMostFrequent(int arr[], int n, int k) {
        // your code here
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<n;i++){
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int freq:h.values()){
            maxHeap.add(freq);
        }
        int sum=0;
        while(k-->0 && !maxHeap.isEmpty()){
            sum+=maxHeap.poll();
        }
        return sum;
    }
    //  DRIVER FUNCTION
    public static void main(String[] args) {
        kMostFrequent obj = new kMostFrequent();

        int[] arr = {1, 1, 1, 2, 2, 3};
        int n = arr.length;
        int k = 2;

        System.out.print("Array: ");
        printArray(arr);

        int result = obj.kMostFrequent(arr, n, k);

        System.out.println("k = " + k);
        System.out.println("Sum of frequencies of k most frequent elements: " + result);
    }

    public static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

}