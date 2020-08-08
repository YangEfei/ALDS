package ALDS1_10_D;

import java.util.Scanner;

// https://blog.csdn.net/sunshine_lyn/article/details/82792697
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double[] p = new double[n+1];
        double[] q = new double[n+1];
        for(int i = 1; i <= n; i++) {
            p[i] = input.nextDouble();
        }
        for(int i = 0; i <= n; i++) {
            q[i] = input.nextDouble();
        }
        System.out.println(getMinCost(n, p, q));
    }
    private static double getMinCost(int n, double[] p, double[] q) {
        double[][] e = new double[n+2][n+1]; // e[1..n+1, 0..n], 第一维下标上界为 n+1 而不是 n，原因在于对于只包含伪关键字dn的子树，我们需要计算并保存e[n+1,n]
                                            // 第二维下标下界为 0 ，是因为对于只包含伪关键字d0的子树，我们需要计算并保存e[1,0]。

        double[][] w = new double[n+2][n+1];
        for(int i = 0; i <=n; i++) {
            e[i+1][i] = q[i]; // 当j=i-1时，说明此时只有伪关键字di-1，故e[i][i-1] = q[i-1]，即e[i+1][i] = q[i]
            w[i+1][i] = q[i];
        }
        for(int l = 1; l <= n; l++) { // 问题规模由小到大
            for(int i = 1; i <= n-l+1; i++) {
                int j = i + l - 1;
                e[i][j] = Double.MAX_VALUE;
                w[i][j] = w[i][j-1] + p[j] + q[j];
                for (int k = i; k <= j; k++) { // 选择一个根 k
                    e[i][j] = Math.min(e[i][j], e[i][k-1] + e[k+1][j] + w[i][j]);
                }
            }
        }
        return e[1][n];
    }
}
