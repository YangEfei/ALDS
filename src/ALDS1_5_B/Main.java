package ALDS1_5_B;

import java.util.Scanner;

public class Main {
    private int count;

    public Main() {
        this.count = 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        Main test = new Main();
        test.mergeSort(num, 0, n);

        for (int i = 0; i < n; i++) {
            System.out.print(num[i]);
            if (i != n - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
        System.out.println(test.count);
    }

    public void merge(int[] num, int left, int mid, int right) {
        int n1 = mid - left;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = num[left + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = num[mid + i];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            count++;
            if (L[i] <= R[j]) {
                num[k++] = L[i++];
            } else {
                num[k++] = R[j++];
            }
        }
        while (i < n1) {
            count++;
            num[k++] = L[i++];
        }
        while (j < n2) {
            count++;
            num[k++] = R[j++];
        }
//        for (int k = left; k < right; k++) {
//            count ++;
//            if (L[i] <= R[j]) {
//                num[k] = L[i++];
//            } else {
//                num[k] = R[j++];
//            }
//        }

    }

    public void mergeSort(int[] num, int left, int right) {
        if (left + 1 < right) {
            int mid = (left + right) / 2;
            mergeSort(num, left, mid);
            mergeSort(num, mid, right);
            merge(num, left, mid, right);
        }
    }
}
