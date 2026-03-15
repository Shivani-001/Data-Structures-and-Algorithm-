package org.example.Heap;

public class HeapImpl {
    int[] harr;
    int capacity;
    int heap_size;

    HeapImpl(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }

    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }

    int extractMin() {
        if (heap_size <= 0) return -1;
        if (heap_size == 1) {
            heap_size--;
            return harr[0];
        }

        int root = harr[0];
        harr[0] = harr[heap_size - 1];
        heap_size--;
        MinHeapify(0);
        return root;
    }

    void insertKey(int k) {
        if (heap_size == capacity) return;

        heap_size++;
        int i = heap_size - 1;
        harr[i] = k;

        while (i > 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    void deleteKey(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    void decreaseKey(int i, int new_val) {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        if (l < heap_size && harr[l] < harr[smallest]) smallest = l;
        if (r < heap_size && harr[r] < harr[smallest]) smallest = r;

        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest);
        }
    }

    // 🔹 DRIVER FUNCTION
    public static void main(String[] args) {
        HeapImpl heap = new HeapImpl(10);

        System.out.println("Inserting elements:");
        heap.insertKey(3);
        heap.insertKey(2);
        heap.insertKey(15);
        heap.insertKey(5);
        heap.insertKey(4);
        heap.insertKey(45);

        System.out.println("Extract Min: " + heap.extractMin()); // 2
        heap.deleteKey(2);  // delete element at index 2
        heap.decreaseKey(2, 1);

        System.out.println("Current Min: " + heap.extractMin()); // 1
        System.out.println("Next Min: " + heap.extractMin());    // 3
    }
}