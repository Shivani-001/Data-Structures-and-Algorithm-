package org.example.Heap;

public class HeapSort {

    public void heapSort(int arr[]) {
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--){ //Build Max Heap
            heapify(arr,n,i);
        }
        for(int i=n-1;i>0;i--){ // Extract elements from heap one by one
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,i,0); // not n in place of i=> as every time it would put at end
        }
    }
    public void heapify(int[] arr, int n, int i){
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<n && arr[left]>arr[largest]) largest=left;
        if(right<n && arr[right]>arr[largest]) largest=right;
        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            heapify(arr,n,largest);
        }
    }

    // DRIVER FUNCTION
    public static void main(String[] args) {
        HeapSort obj = new HeapSort();

        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array:");
        printArray(arr);

        obj.heapSort(arr);

        System.out.println("\nSorted array:");
        printArray(arr);
    }

    // Utility function to print array
    public static void printArray(int arr[]) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
