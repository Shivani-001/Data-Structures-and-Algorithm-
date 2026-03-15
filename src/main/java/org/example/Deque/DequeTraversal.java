package org.example.Deque;

import java.util.ArrayDeque;

public class DequeTraversal {


        // ===== Solution =====
        static class Solution {

            public static void printDeque(ArrayDeque<Integer> deq) {

                // Safe printing (non-destructive)
                StringBuilder sb = new StringBuilder();

                for (int num : deq) {
                    sb.append(num).append(" ");
                }

                System.out.println(sb.toString().trim());
            }
        }

        // ===== Helper: Create Deque =====
        static ArrayDeque<Integer> createDeque(int arr[]) {

            ArrayDeque<Integer> deq = new ArrayDeque<>();

            for (int num : arr)
                deq.add(num);

            return deq;
        }

        // ===== Main Method =====
        public static void main(String[] args) {

            int arr[] = {5, 10, 15, 20, 25};

            ArrayDeque<Integer> deq = createDeque(arr);

            System.out.println("Deque contents:");
            Solution.printDeque(deq);

            // proving it is non-destructive
            System.out.println("Deque after printing (still intact):");
            Solution.printDeque(deq);
        }
    }