package ALDS1_1_A;

import java.util.Scanner;

public class Main {
    private int n;
    private int[] num;

    public Main(int n, int[] num) {
        this.n = n;
        this.num = num;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }

        Main main = new Main(n, num);
        main.insertSort();
    }

    private void insertSort() {
        this.print();
        for (int i = 1; i < n; i++) {
            int key = num[i];
            int j = i - 1;
            while (j >= 0 && num[j] > key) {
                num[j + 1] = num[j];
                j--;
            }
            num[j + 1] = key;
            this.print();
        }
    }

    private void print() {
        for (int k = 0; k < n; k++) {
            System.out.print(num[k]);
            if (k < n - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
    }
}
