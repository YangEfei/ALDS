package ALDS1_10_A;

import java.util.Scanner;

public class Main {
    public static int[] dp = new int[50];
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        // 初始化
        for(int i = 0; i < 50; i++) {
            dp[i] = -1;
        }
        System.out.println(fibonacci(n));
//        System.out.println(makeFibonacci(n));
    }

    // 递归生成斐波那契数列
//    public static int fibonacci(int n) {
//        if(n == 0 || n == 1) {
//            return 1;
//        }
//        return fibonacci(n-2) + fibonacci(n-1);
//    }

    // 通过记忆化递归生成斐波那契数列
    public static int fibonacci(int n) {
        if(n == 0 || n == 1) {
            return dp[n] = 1;
        }
        // 如果dp[n]已经计算完毕
        if(dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = fibonacci(n-2) + fibonacci(n-1);
    }

    // 通过动态规划法生成斐波那契数列
    public static int makeFibonacci(int n) {
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
    }
}
