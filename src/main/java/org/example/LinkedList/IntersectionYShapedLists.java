package org.example.LinkedList;
import java.util.*;
public class IntersectionYShapedLists {
    

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

        public Node intersectPoint(Node head1, Node head2) {

            HashSet<Node> h = new HashSet<>();

            while (head1 != null) {
                h.add(head1);
                head1 = head1.next;
            }

            while (head2 != null) {
                if (h.contains(head2))
                    return head2;

                head2 = head2.next;
            }

            return null;
        }
    }

    // ===== HELPER: CREATE LIST FROM ARRAY =====
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

        Solution sol = new Solution();

        // First List
        Node head1 = createList(new int[]{1,2,3});

        // Second List
        Node head2 = createList(new int[]{10,20});

        // Common Intersection Part
        Node common = createList(new int[]{30,40,50});

        // Attach common part to first list
        Node temp = head1;
        while (temp.next != null)
            temp = temp.next;
        temp.next = common;

        // Attach common part to second list
        temp = head2;
        while (temp.next != null)
            temp = temp.next;
        temp.next = common;

        System.out.print("List 1: ");
        printList(head1);

        System.out.print("List 2: ");
        printList(head2);

        Node intersection = sol.intersectPoint(head1, head2);

        if (intersection != null)
            System.out.println("Intersection Node Data: " + intersection.data);
        else
            System.out.println("No Intersection");
    }
}