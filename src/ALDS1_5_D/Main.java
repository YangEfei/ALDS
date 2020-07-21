package ALDS1_5_D;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        long count = mergeSort(num, 0, n);
        System.out.println(count);
    }

    public static long merge(int[] num, int left, int mid, int right) {
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
        long count = 0;
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                num[k++] = L[i++];
            } else {
                num[k++] = R[j++];
                count += n1 - i;
            }
        }
        while (i < n1) num[k++] = L[i++];
        while (j < n2) {
            num[k++] = R[j++];
            count += n1 - i;
        }
        return count;
    }

    public static long mergeSort(int[] num, int left, int right) {
        if (left + 1 < right) {
            int mid = (left + right) / 2;
            long a = mergeSort(num, left, mid);
            long b = mergeSort(num, mid, right);
            long c = merge(num, left, mid, right);
            return a + b + c;
        }
        return 0;
    }
}
