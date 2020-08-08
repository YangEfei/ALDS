package ALDS1_11_C;

import java.util.*;

public class Main {
    static int WHITE = 0;
    static int GRAY = 1;
    static int BLACK = 2;
    static int[] color;
    static int[] d;
    static int n;
    static int[][] m;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            int v = input.nextInt();
            int in = input.nextInt();
            for (int j = 0; j < in; j++) {
                int u = input.nextInt();
                m[v - 1][u - 1] = 1;
            }
        }
        bfs();

        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + " " + d[i]);
        }

    }

    static void bfs() {
        // 初始化
        color = new int[n];
        d = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = WHITE;
            d[i] = -1;
        }
        color[0] = GRAY;
        d[0] = 0;
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.offer(0); // add()和remove()方法在失败的时候会抛出异常(不推荐)
        while (!Q.isEmpty()) {
            int u = Q.poll();
            for (int v = 0; v < n; v++) {
                if (m[u][v] == 1 && color[v] == WHITE) {
                    color[v] = GRAY;
                    d[v] = d[u] + 1;
                    Q.offer(v);
                }
            }
            color[u] = BLACK;
        }
    }
}
