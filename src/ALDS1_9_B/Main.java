package ALDS1_9_B;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] heap = new int[n];
        for(int i = 0; i < n; i++) {
            heap[i] = input.nextInt();
        }
        buildMaxHeap(heap);
        for(int i = 0; i < n; i++) {
            System.out.print(" " + heap[i]);
        }
        System.out.println();
    }

    public static void buildMaxHeap(int[] heap) { // 自底向上建堆
        for(int i = heap.length/2; i >= 1;  i--) {
            maxHeapify(heap, i);
        }
    }

    public static void maxHeapify(int[] heap, int i) {
        int left = 2*i;
        int right = 2*i + 1;
        int largest;
        if(left <= heap.length && heap[left-1] > heap[i-1]) {
            largest = left;
        } else {
            largest = i;
        }
        if(right <= heap.length && heap[right-1] > heap[largest-1]) {
            largest = right;
        }

        if(largest != i) {// i的子节点值更大时
            int temp = heap[i-1];
            heap[i-1] = heap[largest-1];
            heap[largest-1] = temp;
            maxHeapify(heap, largest);
        }
    }
}
