package ALDS1_11_A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] m = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                m[i][j] = 0;
            }
        }
        for(int i = 0; i < n; i++) {
            int v = input.nextInt();
            int in = input.nextInt();
            for(int j = 0; j < in; j++) {
                int u = input.nextInt();
                m[v-1][u-1] = 1;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                System.out.print(m[i][j]);
                if(j != n-1) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        }
    }
}
