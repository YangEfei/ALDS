package ALDS1_1_B;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int result = gcd(a, b);
        System.out.println(result);
    }

    public static int gcd(int x, int y) {
        if (x % y == 0) {
            return x < y ? x : y;
        }
        if (x >= y) {
            return gcd(y, x % y);
        } else {
            return gcd(x, y % x);
        }
    }
}
