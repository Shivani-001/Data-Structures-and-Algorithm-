package org.example.Deque;

import java.util.*;

public class SlidingWindowMaximum {

    // ===== Solution =====
    static class Solution {

        public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {

            Deque<Integer> d = new ArrayDeque<>();
            ArrayList<Integer> l = new ArrayList<>();

            // ===== Initial approach I tried =====
            // d.addFirst(k-1);
            // for(int i=k-1;i>=0;i++){
            //     if(arr[i]>arr[d.peek()]){
            //         d.addFirst(i);
            //     }
            // }
            // l.add(arr[d.peek()]);
            //
            // for(int i=k;i<arr.length;i++){
            //     if(d.peek()==i-k) d.removeFirst();
            //     if((arr[i]>arr[d.getLast()])){
            //         while(arr[i]>arr[d.getLast()] && !d.isEmpty()) {
            //             d.removeLast();
            //         }
            //         d.addLast(i);
            //     }
            //     l.add(arr[d.peek()]);
            // }
            // return l;

            // ===== Final refined approach =====
            // Core idea: maintain a decreasing deque of indices.
            // Every element in deque must be greater than elements to its right.

            for (int i = 0; i < arr.length; i++) {

                // Remove indices outside current window
                if (!d.isEmpty() && d.peekFirst() == i - k)
                    d.removeFirst();

                // Remove smaller elements from the back
                while (!d.isEmpty() && arr[i] >= arr[d.peekLast()])
                    d.removeLast();

                // Add current index
                d.addLast(i);

                // When first window completes
                if (i >= k - 1)
                    l.add(arr[d.peekFirst()]);
            }

            return l;
        }
    }

    // ===== Helper to print list =====
    static void printList(List<Integer> list) {
        for (int num : list)
            System.out.print(num + " ");
        System.out.println();
    }

    // ===== Main method =====
    public static void main(String[] args) {

        Solution sol = new Solution();

        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Window size: " + k);

        ArrayList<Integer> result = sol.maxOfSubarrays(arr, k);

        System.out.print("Sliding window maximums: ");
        printList(result);
    }
}
