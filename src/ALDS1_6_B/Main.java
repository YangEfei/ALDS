package ALDS1_6_B;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        int anchor = partition(num, 0, n - 1);
        for (int i = 0; i < n; i++) {
            if (i != anchor) {
                System.out.print(num[i]);
            } else {
                System.out.print("[" + num[i] + "]");
            }
            if (i != n - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
    }

    public static int partition(int[] num, int p, int r) {
        int x = num[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (num[j] <= x) {
                i++;
                swap(num, i, j);
            }
        }
        swap(num, i + 1, r);
        return i + 1;
    }

    public static void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
}
