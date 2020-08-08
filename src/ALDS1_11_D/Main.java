package ALDS1_11_D;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int n;
    static int[] idGroup;
    static ArrayList<ArrayList<Integer>> G;
    public static void main(String[] arsg) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int m = input.nextInt();
        G = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++) {
            G.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < m; i++) {
            int s = input.nextInt();
            int t = input.nextInt();
            G.get(s).add(t);
            G.get(t).add(s);
        }

        assignId();

        int q = input.nextInt();
        for(int i = 0; i < q; i++) {
            int s = input.nextInt();
            int t = input.nextInt();
            if(idGroup[s] == idGroup[t]) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    static void assignId() {
        int id = 1;
        idGroup = new int[n];
        for(int i = 0; i < n; i++) {
            idGroup[i] = -1;
        }
        for(int u = 0; u < n; u++) {
            if(idGroup[u] == -1) {
                dfs(u, id++);
            }
        }
    }

    static void dfs(int r, int id){
        Stack<Integer> S = new Stack<Integer>();
        S.push(r);
        idGroup[r] = id;
        while(!S.isEmpty()) {
            int u = S.pop();
            for(int i = 0; i < G.get(u).size(); i++) {
                int v = G.get(u).get(i);
                if(idGroup[v] == -1) {
                    idGroup[v] = id;
                    S.push(v);
                }
            }
        }
    }
}
