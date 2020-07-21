package ALDS1_8_C;

import java.util.Scanner;

public class Main {
    final static int NIL = -2000000001;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        TNode root = new TNode(NIL);
        for(int i = 0; i < n; i++) {
            String cmd = input.next();
            if (cmd.equals("insert")) {
                int key = Integer.parseInt(input.next());
                TNode z = new TNode(key);
                root = insert(root, z);
            } else if (cmd.equals("find")) {
                int key = Integer.parseInt(input.next());
                System.out.println(find(root, key).key != NIL? "yes":"no");
            } else if (cmd.equals("delete")) {
                int key = Integer.parseInt(input.next());
                root = delete(root, key);
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
    public static TNode find(TNode root, int key) {
        TNode x = root;
        TNode y = new TNode(NIL);
        while( x.key != NIL) {
            if (key == x.key) {
                y = x;
                break;
            } else if(key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return y;
    }
    public static TNode delete(TNode root, int key) {
        TNode y;
        TNode x;
        TNode z = find(root, key);
        if(z.left.key == NIL || z.right.key == NIL) {
            y = z; // z 没有或只有一个子节点时，要删除的对象为 z
        } else {
            y = getSuccessor(z); // z 有两个子节点时，删除对象为 z 的后一个节点（指中序遍历的后一个节点）
        }
        if(y.left.key != NIL) {
            x = y.left; // 如果 y 有左子节点，则 x 为 y 的左子节点
        } else {
            x = y.right; // 如果 y 没有左子节点，则 x 为 y 的右子节点
        }

        if(x.key != NIL) {
            x.parent = y.parent; // 设置 x 的父节点
        }
        if(y.parent.key == NIL) {
            root = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }
        if(y != z) { // z 的最后一个节点被删除时
            z.key = y.key; // 将 y 的数据复制到 z 中
        }
        return root;
    }
    public static TNode getSuccessor(TNode x) {
        if(x.right.key != NIL) {
            return getMinium(x.right);
        }
        TNode y = x.parent;
        while(y.key != NIL && x == y.right) { // 寻找中序遍历后一个节点
            x = y;
            y = y.parent;
        }
        return y;
    }
    public static TNode getMinium(TNode x) {
        while (x.left.key != NIL) {
            x = x.left;
        }
        return x;
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
