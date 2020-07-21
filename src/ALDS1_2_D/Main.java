package ALDS1_2_D;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private int cnt;
    private ArrayList<Integer> G = null;

    public Main() {
        this.cnt = 0;
        this.G = new ArrayList<>();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        Main test = new Main();
        test.shellSort(num, n);
        System.out.println(test.G.size());
        for (int i = test.G.size() - 1; i >= 0; i--) {
            System.out.print(test.G.get(i));
            if (i != 0) System.out.print(" ");
        }
        System.out.println();
        System.out.println(test.cnt);
        for (int i = 0; i < n; i++) {
            System.out.println(num[i]);
        }
    }

    private void insertionSort(int[] num, int n, int g) {
        for (int i = g; i < n; i++) {
            int key = num[i];
            int j = i - g;
            while (j >= 0 && num[j] > key) {
                num[j + g] = num[j];
                j -= g;
                cnt++;
            }
            num[j + g] = key;
        }
    }

    private void shellSort(int[] num, int n) {
        for (int h = 1; ; ) {
            if (h > n) break;
            G.add(h);
            h = 3 * h + 1;
        }

        for (int i = G.size() - 1; i >= 0; i--) {
            insertionSort(num, n, G.get(i));
        }
    }
}
