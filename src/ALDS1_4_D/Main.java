package ALDS1_4_D;

import java.util.Scanner;

public class Main {
    private int n;
    private int k;
    private int[] w;

    public Main(int n, int k, int[] w) {
        this.n = n;
        this.k = k;
        this.w = w;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }
        Main test = new Main(n, k, w);
        System.out.println(test.solve());

    }

    public int solve() {
        int left = 0;
        int right = 100000 * 10000; // 货物数 * 1件货物的最大重量，即最大货物总重量
        int mid;
        while (right - left > 1) {
            mid = (left + right) / 2;
            if(check(mid) >= n) right = mid;
            else left = mid;
        }

        return right;
    }

    public int check(int p) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            int s = 0;
            while (s + w[count] <= p) {
                s += w[count];
                count++;
                if (count == n) return n;
            }
        }
        return count;
    }
}
