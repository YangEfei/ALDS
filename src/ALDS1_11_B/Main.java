package ALDS1_11_B;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int WHITE = 0;
    static int GRAY = 1;
    static int BLACK = 2;
    static int[] color;
    static int[] d;
    static int[] f;
    static int time;
    static int n;
    static int[][] m;
    static int[] nt; // 当前u访问过的最大的节点编号

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = new int[n][n];
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
        dfs();

        for(int i = 0; i < n; i++) {
            System.out.println(i+1 + " " + d[i] + " " + f[i]);
        }

    }
    static void dfs() {
        // 初始化
        color = new int[n];
        d = new int[n];
        f = new int[n];
        for(int i = 0; i < n; i++) {
            color[i] = WHITE;
        }
        time = 0;
        for(int u = 0; u < n; u++) {
            if(color[u] == WHITE) {
                dfs_visit(u);
            }
        }
    }

    // 递归实现
//    static void dfs_visit(int u) {
//        color[u] = GRAY;
//        d[u] = ++time;
//        for(int v = 0; v < n; v++){
//            if(m[u][v] == 0) continue;
//            if(color[v] == WHITE) {
//                dfs_visit(v);
//            }
//        }
//        color[u] = BLACK;
//        f[u] = ++time;
//    }

    // 栈实现
    static void dfs_visit(int r) {
        nt = new int[n];
        for (int i = 0; i < n; i++) {
            nt[i] = 0;
        }

        Stack<Integer> S = new Stack<>();
        S.push(r);
        color[r] = GRAY;
        d[r] = ++time;

        while(!S.isEmpty()) {
            int u = S.peek();
            int v = next(u);
            if(v != -1) {
                if(color[v] == WHITE) {
                    color[v] = GRAY;
                    d[v] = ++time;
                    S.push(v);
                }
            } else {
                S.pop();
                color[u] = BLACK;
                f[u] = ++time;
            }
        }
    }

    // 按编号顺序获取与u相邻的v
    static int next(int u) {
        for(int v = nt[u]; v < n; v++) {
            nt[u] = v + 1;
            if(m[u][v] == 1) return v;
        }
        return -1;
    }
}
