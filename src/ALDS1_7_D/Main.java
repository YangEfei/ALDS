package ALDS1_7_D;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int pos = 0;
    static ArrayList<Integer> pre = new ArrayList<>();
    static ArrayList<Integer> in = new ArrayList<>();
    static ArrayList<Integer> post = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for(int i = 0; i < n; i++) {
            pre.add(input.nextInt());
        }
        for(int i = 0; i < n; i++) {
            in.add(input.nextInt());
        }
        rec(0, pre.size()); // 用 in 的下标 left 和 right 表示 Preorder 当前访问的子树的范围（不包含 r）
        for(int i = 0; i < post.size(); i++) {
            System.out.print(post.get(i));
            if (i != post.size() - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
    }

    public static void rec(int left, int right) {
        if(left >= right) {
            return;
        }
        int root = pre.get(pos++);
        int middle = getIndex(in, root);

        rec(left, middle);
        rec(middle+1, right);

        post.add(root); // 左-右-根，此时访问的顺序相当于后序遍历
    }

    public static int getIndex(ArrayList<Integer> arr, int value) {
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i) == value) {
                return i;
            }
        }
        return -1;
    }
}