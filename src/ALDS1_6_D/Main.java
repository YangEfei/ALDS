package ALDS1_6_D;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] w = new int[n];
        int maxV = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
            if (w[i] > maxV) maxV = w[i];
        }
        int result = minCostSort(w, n, maxV);
        System.out.println(result);
    }

    public static int minCostSort(int[] w, int n, int maxV) {
        int ans = 0;  // 初始化结果

        boolean[] visit = new boolean[n];  // 已访问标记数组
        for (int i = 0; i < n; i++) {
            visit[i] = false;
        }

        int[] sortedW = w.clone();  // 有序成本数组
        Arrays.sort(sortedW);

        int[] T = new int[maxV + 1];  // 某成本对应的顺序序号
        for (int i = 0; i < n; i++) {
            T[sortedW[i]] = i;
        }
        int x = sortedW[0];

        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;  // 已访问过，则接着访问下一个
            int cur = i;  // 当前访问位置
            int sum = 0;  // 环路内总成本
            int min = maxV;  // 环路内最小成本
            int count = 0;  // 环路总长度

            // 寻找该成本在实际顺序中的对应位置，即交换位置
            while (!visit[cur]) {
                visit[cur] = true;
                count++;
                int v = w[cur];
                min = Math.min(min, v);
                sum += v;
                cur = T[v];
            }

            ans += Math.min(sum + (count - 2) * min, min + sum + (count + 1) * x);
        }
        return ans;
    }
}
