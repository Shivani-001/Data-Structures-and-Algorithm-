package org.example.Heap;
//Given an array arr[] of positive integers and a number k. The task is to find the kth smallest element in the array.

public class kthSmallestElement {

    public int kthSmallest(int[] arr, int k) {
        // code here
        //as we find kth largest
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--)
            heapify(arr,n,i);
        for(int i=n-1;i>=n-k+1;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,i,0);
        }
        return arr[0];
    }
    public void heapify(int[] arr, int n, int i){
        int smallest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<n && arr[left]<arr[smallest])smallest=left;
        if(right<n && arr[right]<arr[smallest])smallest=right;
        if(i!=smallest){
            int t=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=t;
            heapify(arr,n,smallest);
        }
    }

    // DRIVER FUNCTION
    public static void main(String[] args) {
        kthSmallestElement obj = new kthSmallestElement();

        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        System.out.print("Array: ");
        printArray(arr);

        int result = obj.kthSmallest(arr, k);

        System.out.println("k = " + k);
        System.out.println("Kth Smallest Element: " + result);
    }

    public static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }
}
