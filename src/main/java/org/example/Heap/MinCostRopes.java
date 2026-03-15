package org.example.Heap;

public class MinCostRopes {

//Given an array, arr[] of rope lengths, connect all ropes into a single rope with the minimum total cost. The cost to connect two ropes is the sum of their lengths.

public static int minCost(int[] arr) {
    // code here
    //create min heap
    int n=arr.length;
    int heap_size=n;
    for(int i=n/2-1;i>=0;i--)
        heapify(arr,n,i);

    //add the root + min(left,right) and remove both nodes and add the sum at root
    int cost=0;
    while(heap_size>1){
        int first=extractMin(arr,heap_size--);
        int second=extractMin(arr,heap_size--);
        int sum=first+second;
        cost+=sum;
        arr[heap_size++]=sum;
        heapifyUp(arr,heap_size-1);
    }
    return cost;
}
static void heapifyUp(int[] arr, int i){
    while(i>0){
        int parent=(i-1)/2;
        if(arr[parent]<arr[i]) return;
        swap(arr,parent,i);
        i=parent;
    }
}
static int extractMin(int[] arr, int size){
    int min=arr[0];
    arr[0]=arr[size-1];
    heapify(arr,size-1,0);
    return min;
}
public static void swap(int[] arr,int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}
public static void heapify(int[] arr, int n,int i){
    int smallest=i;
    int left=2*i+1;
    int right=2*i+2;
    if(left<n && arr[left]<arr[smallest]) smallest=left;
    if(right<n && arr[right]<arr[smallest] )smallest=right;
    if(i!=smallest){
        swap(arr,smallest,i);
        heapify(arr,n,smallest);
    }
}
//  DRIVER FUNCTION
public static void main(String[] args) {
    int[] ropes = {4, 3, 2, 6};

    System.out.print("Ropes: ");
    printArray(ropes);

    int result = minCost(ropes);

    System.out.println("Minimum cost to connect ropes: " + result);
}

public static void printArray(int[] arr) {
    for (int num : arr) System.out.print(num + " ");
    System.out.println();
}
}