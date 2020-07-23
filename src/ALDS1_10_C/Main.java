package ALDS1_10_C;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            String x = input.next();
            String y = input.next();
            System.out.println(lcs(x,y));
        }
    }

    public static int lcs(String x, String y) {
        int m = x.length();
        int n = y.length();
        int[][] c = new int[m+1][n+1];
        for(int i = 1; i <= m; i++) {
            c[i][0] = 0;
        }
        for(int j = 1; j <= n; j++) {
            c[0][j] = 0;
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                } else if (c[i-1][j] >= c[i][j-1]) {
                    c[i][j] = c[i-1][j];
                } else {
                    c[i][j] = c[i][j-1];
                };
            }
        }
        return c[m][n];
    }
}
