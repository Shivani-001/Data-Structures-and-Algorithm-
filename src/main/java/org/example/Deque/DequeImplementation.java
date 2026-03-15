package org.example.Deque;

import java.util.ArrayDeque;

public class DequeImplementation {

        public static void pb(ArrayDeque<Integer> dq, int x) {
            //  code here
            dq.addLast(x);
        }

        public static void ppb(ArrayDeque<Integer> dq) {

            //  code here
            if(!dq.isEmpty()) dq.removeLast();
            else return;
        }


        public static int front_dq(ArrayDeque<Integer> dq) {
            //  code here
            if(!dq.isEmpty()) return  dq.peek();
            else return -1;
        }


        public static void pf(ArrayDeque<Integer> dq, int x) {
            //  code here
            dq.addFirst(x);
        }

    static void printDeque(ArrayDeque<Integer> dq) {
        for (int num : dq) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // ===== Main Method =====
    public static void main(String[] args) {

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        System.out.println("Initial deque:");
        printDeque(dq);

        // push back
        pb(dq, 10);
       pb(dq, 20);
       pb(dq, 30);

        System.out.println("After pb (push back):");
        printDeque(dq);

        // push front
        pf(dq, 5);

        System.out.println("After pf (push front):");
        printDeque(dq);

        // front element
        System.out.println("Front element: " + front_dq(dq));

        // pop back
       ppb(dq);

        System.out.println("After ppb (pop back):");
        printDeque(dq);
    }
    }
