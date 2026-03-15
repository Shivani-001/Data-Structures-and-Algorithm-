package org.example.Deque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class DequeInsertion {

    // ===== Solution =====
    static class Solution {

        public Deque<Integer> dqInsertion(List<Integer> arr) {

            Deque<Integer> d = new ArrayDeque<>();

            for (int num : arr)
                d.add(num);

            return d;
        }
    }

    // ===== Helper: Print Deque =====
    static void printDeque(Deque<Integer> dq) {

        for (int num : dq) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    // ===== Main Method =====
    public static void main(String[] args) {

        Solution sol = new Solution();

        List<Integer> arr = Arrays.asList(10, 20, 30, 40, 50);

        Deque<Integer> result = sol.dqInsertion(arr);

        System.out.println("Deque after insertion:");
        printDeque(result);
    }
}
