package ALDS1_4_B;

import java.util.Scanner;

public class Main {
    public boolean binarySearch(int[] s, int n, int key) {
        int left = 0;
        int right = n;
        int mid;
        while (left < right) {  // 表示搜索范围不为空
            mid = (left + right) / 2;
            if(key == s[mid]) return true;  // 发现 key
            else if(key > s[mid]) left = mid + 1;  // 搜索后半部分
            else right = mid;  // 搜索前半部分
        }
        return false;
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
            if (test.binarySearch(s, n, key)) sum++;
        }
        System.out.println(sum);
    }
}
