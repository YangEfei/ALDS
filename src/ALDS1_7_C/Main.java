package ALDS1_7_C;

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
            if(nodes[i].parent == NIL) root = i;
        }

        System.out.println("Preorder");
        preOrder(root);
        System.out.println();
        System.out.println("Inorder");
        inOrder(root);
        System.out.println();
        System.out.println("Postorder");
        postOrder(root);
        System.out.println();
    }

    public static void preOrder(int id) {
        if(id == NIL) {
            return;
        }
        System.out.print(" " + id);
        preOrder(nodes[id].left);
        preOrder(nodes[id].right);
    }

    public static void inOrder(int id) {
        if(id == NIL) {
            return;
        }
        inOrder(nodes[id].left);
        System.out.print(" " + id);
        inOrder(nodes[id].right);
    }

    public static void postOrder(int id) {
        if(id == NIL) {
            return;
        }
        postOrder(nodes[id].left);
        postOrder(nodes[id].right);
        System.out.print(" " + id);
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