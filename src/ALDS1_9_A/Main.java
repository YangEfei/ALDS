package ALDS1_9_A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] heap = new int[n];
        for(int i = 0; i < n; i++) {
            heap[i] = input.nextInt();
        }
        for(int i = 0; i < n; i++) {
            print(i+1, heap);
            System.out.println();
        }
    }

    public static void print(int node, int[] heap) {
        System.out.print("node " + node + ": key = " + heap[node-1] + ", ");
        if(Math.floor(node/2) != 0) {
            System.out.print("parent key = " + heap[(int)Math.floor(node/2)-1] + ", ");
        }
        if(2 * node <= heap.length) {
            System.out.print("left key = " + heap[2*node-1] + ", ");
        }
        if(2 * node + 1 <= heap.length) {
            System.out.print("right key = " + heap[2*node] + ", ");
        }
    }
}
