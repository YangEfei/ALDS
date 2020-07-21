package ALDS1_4_A;

import java.util.Scanner;

public class Main {
    public boolean search(int[] s, int n, int key) {
        int i = 0;
        s[n] = key;
        while (s[i] != key) i++;
        return i != n;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i] = in.nextInt();
        }

        int q = in.nextInt();

        Main test = new Main();
        int sum = 0;

        for (int i = 0; i < q; i++) {
            int key = in.nextInt();
            if(test.search(s, n, key)) sum++;
        }
        System.out.println(sum);
    }
}
