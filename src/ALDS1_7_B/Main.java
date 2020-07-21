package ALDS1_7_B;

import java.util.Scanner;

public class Main {
    static final int NIL = -1;
    static final int MAX = 26;
    static TNode[] nodes = new TNode[MAX];
    static int[] depth = new int[MAX];
    static int[] height = new int[MAX];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n; i++) {
            nodes[i] = new TNode(NIL, NIL, NIL);
        }
        for(int i = 0; i < n; i++) {
            int id = input.nextInt();
            int left = input.nextInt();
            int right = input.nextInt();

            nodes[id].left = left;
            nodes[id].right = right;

            if( left != NIL) {
                nodes[left].parent = id;
            }
            if(right != NIL) {
                nodes[right].parent = id;
            }
        }
        int root = 0;
        for(int i = 0; i < n; i++) {
            if (nodes[i].parent == NIL) root = i;
        }

        getHeight(root);
        getDepth(root, 0);

        for(int i = 0; i < n; i++) {
            print(i);
        }
    }

    public static int getSibling(int id) {
        int sibling = NIL;
        if (nodes[id].parent != NIL) {
            if(nodes[nodes[id].parent].left != id && nodes[nodes[id].parent].left != NIL) {
                sibling = nodes[nodes[id].parent].left;
            }
            if(nodes[nodes[id].parent].right != id && nodes[nodes[id].parent].right != NIL) {
                sibling = nodes[nodes[id].parent].right;
            }
        }
        return sibling;
    }

    public static int getHeight(int id) {
        int h1 = 0, h2 = 0;
        if(nodes[id].left != NIL) {
            h1 = getHeight(nodes[id].left) + 1;
        }
        if(nodes[id].right != NIL) {
            h2 = getHeight(nodes[id].right) + 1;
        }
        return height[id] = h1 > h2? h1: h2;
    }
    public static void getDepth(int id, int d) {
        if(id == NIL) return;
        depth[id] = d;
        getDepth(nodes[id].left, d + 1);
        getDepth(nodes[id].right, d + 1);
    }

    public static void print(int id) {
        System.out.print("node " + id + ": ");
        System.out.print("parent = " + nodes[id].parent + ", ");
        System.out.print("sibling = " + getSibling(id) + ", ");
        int degree = 0;
        if (nodes[id].left != NIL) {
            degree++;
        }
        if (nodes[id].right != NIL) {
            degree++;
        }
        System.out.print("degree = " + degree + ", ");
        System.out.print("depth = " + depth[id] + ", ");
        System.out.print("height = " + height[id] + ", ");

        if(nodes[id].parent == NIL) {
            System.out.println("root");
        } else if (nodes[id].left == NIL && nodes[id].right == NIL) {
            System.out.println("leaf");
        } else {
            System.out.println("internal node");
        }
    }
}

class TNode {
    public int parent, left, right;

    public TNode(int parent, int left, int right) {
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}