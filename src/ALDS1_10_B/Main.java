package ALDS1_10_B;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] p = new int[n+1];
        int[][] m = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            p[i-1] = input.nextInt();
            p[i] = input.nextInt();
        }
        matrixChainMultiplication(m, p, n);
        System.out.println(m[1][n]);
    }
    public static void matrixChainMultiplication(int[][] m, int[] p, int n) {
        for(int i = 0; i <=n; i++) { // 初始化，所有(Mi)成本为0
            m[i][i] = 0;
        }
        for(int l = 2; l <= n; l++) { // 对象矩阵的数量
            for(int i = 1; i <= n-l+1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for(int k = i; k <= j - 1; k++) {
                    m[i][j] = Math.min(m[i][j], m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j]);
                }
            }
        }
    }
}
