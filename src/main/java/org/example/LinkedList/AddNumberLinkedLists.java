package org.example.LinkedList;

import java.util.*;

public class AddNumberLinkedLists {

    // ===== Node Definition =====
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // ===== SOLUTION =====
    static class Solution {

        static Node addTwoLists(Node num1, Node num2) {

            num1 = reverseList(num1);
            num2 = reverseList(num2);

            int x = 0, c = 0;

            Node dummy = new Node(0);
            Node temp = dummy;

            while (num1 != null || num2 != null || c != 0) {

                x = c;

                if (num1 != null) {
                    x += num1.data;
                    num1 = num1.next;
                }

                if (num2 != null) {
                    x += num2.data;
                    num2 = num2.next;
                }

                c = x / 10;

                temp.next = new Node(x % 10);
                temp = temp.next;
            }

            Node result = reverseList(dummy.next);

            while (result != null && result.data == 0 && result.next != null)
                result = result.next;

            return result;
        }

        static Node reverseList(Node N) {

            Node prev = null;
            Node current = N;

            while (current != null) {
                Node next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            return prev;
        }
    }

    // ===== HELPER: CREATE LINKED LIST FROM ARRAY =====
    static Node createList(int arr[]) {

        Node head = new Node(arr[0]);
        Node curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    // ===== HELPER: PRINT LIST =====
    static void printList(Node head) {

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }

        System.out.println("null");
    }

    // ===== MAIN METHOD =====
    public static void main(String[] args) {

        // Test Case 1
        int num1[] = {4, 5};
        int num2[] = {3, 4, 5};

        Node list1 = createList(num1);
        Node list2 = createList(num2);

        System.out.print("Number 1: ");
        printList(list1);

        System.out.print("Number 2: ");
        printList(list2);

        Node result = Solution.addTwoLists(list1, list2);

        System.out.print("Sum: ");
        printList(result);


        // Test Case 2
        int num3[] = {9, 9, 9};
        int num4[] = {1};

        Node list3 = createList(num3);
        Node list4 = createList(num4);

        System.out.print("\nNumber 1: ");
        printList(list3);

        System.out.print("Number 2: ");
        printList(list4);

        Node result2 = Solution.addTwoLists(list3, list4);

        System.out.print("Sum: ");
        printList(result2);
    }
}
