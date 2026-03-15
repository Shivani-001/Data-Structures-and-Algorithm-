package org.example.Heap;

public class nearly_sorted {
//    Given an array arr[], where each element is at most k positions away from its correct position in the sorted order.
//    Your task is to restore the sorted order of arr[] by rearranging the elements in place.
//
//    Note: Don't use any sort() method.
        public void nearlySorted(int[] arr, int k) {
            // code here
            int n=arr.length;
            int heapSize=Math.min(k+1,n);

            int heap[]=new int[heapSize]; // if not explicitely used => o/p overrides heap candidates
            for(int i=0;i<heapSize;i++) heap[i]=arr[i];

            //building heap
            for(int i=heapSize/2-1;i>=0;i--) heapifyDown(heap,heapSize,i);

            //process remaining elements
            int index=0;
            for(int i=k+1;i<n;i++){
                arr[index++]=heap[0];
                heap[0]=arr[i];
                heapifyDown(heap,heapSize,0);
            }
            //Empty Heap
            while(heapSize>0){
                arr[index++]=heap[0];
                heap[0]=heap[heapSize-1];
                heapSize--;
                heapifyDown(heap,heapSize,0);
            }
        }

        public void heapifyDown(int[] arr, int n, int i){
            int smallest=i;
            int left=2*i+1;
            int right=2*i+2;

            if(left<n && arr[left]<arr[smallest]) smallest=left;
            if(right<n && arr[right]<arr[smallest]) smallest=right;
            if(smallest!=i){
                int temp=arr[i];
                arr[i]=arr[smallest];
                arr[smallest]=temp;
                heapifyDown(arr,n,smallest);
            }
        }
    // DRIVER FUNCTION
    public static void main(String[] args) {
        nearly_sorted obj = new nearly_sorted();

        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;

        System.out.print("Original array: ");
        printArray(arr);

        obj.nearlySorted(arr, k);

        System.out.print("Sorted array:   ");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }
    }


