package ALDS1_2_B;

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
        Main test = new Main(n, num);
        int count = test.selectionSort();
        for (int i = 0; i < n; i++) {
            System.out.print(num[i]);
            if (i < n - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
        System.out.println(count);
    }

    private int selectionSort() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int mini = i;
            for (int j = i; j < n; j++) {
                if (num[j] < num[mini]) {
                    mini = j;
                }
            }
            swap(i, mini);
            if (i != mini) count++;
        }
        return count;
    }

    private void swap(int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
}
