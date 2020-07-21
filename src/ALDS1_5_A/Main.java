package ALDS1_5_A;

import java.util.Scanner;

public class Main {
    private int n;
    private int[] A;

    public Main(int n, int[] A) {
        this.n = n;
        this.A = A;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        Main test = new Main(n, A);
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int m = in.nextInt();
            if(test.solve(0, m)) System.out.println("yes");
            else System.out.println("no");

        }
    }

    public boolean solve(int i, int m) {
        if (m == 0) return true;
        if (i >= n) return false;
        boolean result = solve(i + 1, m) || solve(i + 1, m - A[i]);
        return result;
    }
}
