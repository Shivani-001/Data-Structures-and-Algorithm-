package org.example.Heap;

//Given a data stream arr[] where integers are read sequentially, the task is to determine the median of the elements encountered so far after each new integer is read.
//The median is defined as follows:
//        1. Odd number of elements: The median is the middle element when the current set of numbers is sorted.
//        2. Even number of elements: The median is the arithmetic mean (average) of the two middle elements when the current set of numbers is sorted.

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Find_Median_in_stream {
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        ArrayList<Double> result=new ArrayList<>();
        PriorityQueue<Integer> left=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right=new PriorityQueue<>();
        for(int num:arr){
            //Step 1. Add to heap
            if(left.isEmpty() || num<=left.peek() ){
                left.add(num);
            }
            else right.add(num);

            //Step 2 . Rebalance
            if(left.size()>right.size()+1)
                right.add(left.poll());
            else  if(left.size()<right.size())
                left.add(right.poll());

            // Step 3 . Find Median
            if(left.size()==right.size())
                result.add((double)(left.peek()+right.peek())/2);
            else result.add((double)left.peek())  ;
        }
        return result;
    }
    // DRIVER FUNCTION
    public static void main(String[] args) {
        Find_Median_in_stream obj = new Find_Median_in_stream();

        int[] stream = {5, 15, 1, 3};

        System.out.print("Stream: ");
        printArray(stream);

        ArrayList<Double> medians = obj.getMedian(stream);

        System.out.println("Running medians:");
        System.out.println(medians);
    }

    public static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

}