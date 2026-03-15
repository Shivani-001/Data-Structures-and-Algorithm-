package org.example.Heap;

//You are given a 2D matrix mat[][] of size n x m.
// Each row in the matrix is sorted in non-decreasing order.
// Your task is to merge all the rows and return a single sorted array
// that contains all the elements of the matrix.

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    static class Node{
        int value;
        int row;
        int col;
        Node(int value,int row,int col){
            this.value=value;
            this.row=row;
            this.col=col;
        }
    }
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
        int n=mat.length;
        int m=mat[0].length;
        ArrayList<Integer> result=new ArrayList<Integer>();
        PriorityQueue<Node> minHeap=new PriorityQueue<>(
                (a,b)->a.value-b.value
        );

        for(int i=0;i<n;i++){
            minHeap.add(new Node(mat[i][0],i,0));
        }

        while(!minHeap.isEmpty()){
            Node curr=minHeap.poll();
            result.add(curr.value);
            if(curr.col+1<m){
                minHeap.add(new Node(mat[curr.row][curr.col+1],curr.row,curr.col+1));
            }
        }
        return result;
    }
    // DRIVER FUNCTION
    public static void main(String[] args) {
        MergeKSortedArrays obj = new MergeKSortedArrays();

        int[][] mat = {
                {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}
        };

        System.out.println("Input arrays:");
        printMatrix(mat);

        ArrayList<Integer> merged = obj.mergeArrays(mat);

        System.out.println("\nMerged array:");
        System.out.println(merged);
    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }

}

