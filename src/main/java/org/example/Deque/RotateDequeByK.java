package org.example.Deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class RotateDequeByK {


        // ===== Solution =====
        static class Solution {

            public static void rotateDeque(Deque<Integer> dq, int type, int k) {

                int n = dq.size();

                if (n == 0)
                    return;

                k = k % n;

                // Right rotation
                if (type == 1) {

                    for (int i = 0; i < k; i++) {
                        int last = dq.pollLast();
                        dq.offerFirst(last);
                    }

                }
                // Left rotation
                else if (type == 2) {

                    for (int i = 0; i < k; i++) {
                        int first = dq.pollFirst();
                        dq.offerLast(first);
                    }
                }
            }
        }

        // ===== Helper: Create Deque =====
        static Deque<Integer> createDeque(int arr[]) {

            Deque<Integer> dq = new ArrayDeque<>();

            for (int num : arr)
                dq.offerLast(num);

            return dq;
        }

        // ===== Helper: Print Deque =====
        static void printDeque(Deque<Integer> dq) {

            for (int num : dq)
                System.out.print(num + " ");

            System.out.println();
        }

        // ===== Main Method =====
        public static void main(String[] args) {

            Deque<Integer> dq = createDeque(new int[]{1,2,3,4,5});

            System.out.print("Original deque: ");
            printDeque(dq);

            // Right rotation
            Solution.rotateDeque(dq, 1, 2);

            System.out.print("After right rotation by 2: ");
            printDeque(dq);

            // Left rotation
            Solution.rotateDeque(dq, 2, 1);

            System.out.print("After left rotation by 1: ");
            printDeque(dq);
        }
    }
