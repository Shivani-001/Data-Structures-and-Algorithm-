package org.example.Deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDeletion {


    // ===== Solution =====
    static class Solution {

        public static void eraseAt(ArrayDeque<Integer> deq, int X) {

            Deque<Integer> temp = new ArrayDeque<>();

            for (int i = 0; i < X; i++)
                temp.push(deq.pop());

            deq.pop(); // remove Xth element

            while (!temp.isEmpty())
                deq.push(temp.pop());
        }

        public static void eraseInRange(ArrayDeque<Integer> deq, int start, int end) {

            if (start >= end)
                return;

            if (start < 0)
                start = 0;

            if (end > deq.size())
                end = deq.size();

            Deque<Integer> temp = new ArrayDeque<>();
            int index = 0;

            while (!deq.isEmpty()) {

                int num = deq.removeFirst();

                if (index < start || index >= end)
                    temp.addLast(num);

                index++;
            }

            deq.addAll(temp);
        }

        public static void eraseAll(ArrayDeque<Integer> deq) {

            deq.clear();
        }
    }

    // ===== Helper: Print Deque =====
    static void printDeque(ArrayDeque<Integer> deq) {

        for (int num : deq)
            System.out.print(num + " ");

        System.out.println();
    }

    // ===== Main Method =====
    public static void main(String[] args) {

        ArrayDeque<Integer> deq = new ArrayDeque<>();

        deq.add(10);
        deq.add(20);
        deq.add(30);
        deq.add(40);
        deq.add(50);
        deq.add(60);

        System.out.print("Original Deque: ");
        printDeque(deq);

        // eraseAt
        Solution.eraseAt(deq, 2);
        System.out.print("After eraseAt(2): ");
        printDeque(deq);

        // eraseInRange
        Solution.eraseInRange(deq, 1, 3);
        System.out.print("After eraseInRange(1,3): ");
        printDeque(deq);

        // eraseAll
        Solution.eraseAll(deq);
        System.out.print("After eraseAll: ");
        printDeque(deq);
    }
}
