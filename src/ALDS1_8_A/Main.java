package ALDS1_8_A;

import java.util.Scanner;

public class Main {
    final static int NIL = -1;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        TNode root = new TNode(NIL);
        for(int i = 0; i < n; i++) {
            String cmd = input.next();
            if(cmd.equals("insert")) {
                int key = Integer.parseInt(input.next());
                TNode z = new TNode(key);
                root = insert(root, z);
            } else if (cmd.equals("print")) {
                inOrder(root);
                System.out.println();
                preOrder(root);
                System.out.println();
            }
        }
    }
    public static TNode insert(TNode root, TNode z) {
        TNode y = new TNode(NIL); // 前一个节点
        TNode x = root; // 当前节点

        z.left = new TNode(NIL);
        z.right = new TNode(NIL);

        while( x.key != NIL ){ // 当前节点不为空
            y = x; // y 指向当前节点
            if( z.key < x.key ) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        z.parent = y;
        if( y.key == NIL ){
            root = z;
        } else {
            if( z.key < y.key ) {
                y.left = z;
            } else {
                y.right = z;
            }
        }
        return root;
    }
    public static void preOrder(TNode node) {
        if(node.key == NIL) {
            return;
        }
        System.out.print(" " + node.key);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void inOrder(TNode node) {
        if(node.key == NIL) {
            return;
        }
        inOrder(node.left);
        System.out.print(" " + node.key);
        inOrder(node.right);
    }
}

class TNode {
    int key;
    TNode left, right ,parent;
    TNode(int key) {
        this.key = key;
    }
}
