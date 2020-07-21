package ALDS1_8_D;

import java.util.Scanner;

public class Main {
    final static int NIL = -1;
    public static TNode root = new TNode(NIL, NIL);
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n; i++) {
            String cmd = input.next();
            if (cmd.equals("insert")) {
                int key = Integer.parseInt(input.next());
                int pri = Integer.parseInt(input.next());
                TNode z = new TNode(key, pri);
                insert(root, z);
            } else if (cmd.equals("find")) {
                int key = Integer.parseInt(input.next());
                System.out.println(find(root, key).key != NIL? "yes":"no");
            } else if (cmd.equals("delete")) {
                int key = Integer.parseInt(input.next());
                delete(root, key);
            } else if (cmd.equals("print")) {
                inOrder(root);
                System.out.println();
                preOrder(root);
                System.out.println();
            }
        }
    }
    public static TNode insert(TNode t, TNode z) {
        if(t.key == NIL) {
            z.left = new TNode(NIL, NIL);
            z.right = new TNode(NIL, NIL);
            if(t.parent == null) { // 如果为空树，修改 root
                z.parent = new TNode(NIL, NIL);
                root = z;
            }
            return z; // 达到叶子节点时创建新节点
        }
        if(z.key == t.key) {
            return t; // 忽略重复 key
        } else if(z.key < t.key) {
            t.left.parent = t;
            t.left = insert(t.left, z);
            if(t.pri < t.left.pri) {
                t = rightRotate(t);
            }
        } else {
            t.right.parent = t;
            t.right = insert(t.right, z);
            if (t.pri< t.right.pri) {
                t = leftRotate(t);
            }
        }
        return t;
    }
    public static TNode rightRotate(TNode t) {
        TNode s = t.left;
        s.parent = t.parent;
        if(t.parent.key == NIL) {
            root = s;
        }
        t.parent = s;
        t.left = s.right;
        s.right = t;
        return s;
    }
    public static TNode leftRotate(TNode t) {
        TNode s = t.right;
        s.parent = t.parent;
        if(t.parent.key == NIL) {
            root = s;
        }
        t.parent = s;
        t.right = s.left;
        s.left = t;
        return s;
    }
    public static TNode find(TNode root, int key) {
        TNode x = root;
        TNode y = new TNode(NIL, NIL);
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
    public static TNode delete(TNode t, int key) { // 递归寻找目标
        if(t.key == NIL) { // 找不到目标（或已被删除）
            return new TNode(NIL, NIL);
        }
        if(key < t.key) {
            t.left = delete(t.left, key);
        } else if(key > t.key) {
            t.right = delete(t.right, key);
        } else { // 找到目标
            return _delete(t, key);
        }
        return t;
    }
    public static TNode _delete(TNode t, int key) {
        // 递归终止条件：
        if(t.left.key == NIL && t.right.key == NIL) { // 如果是叶子节点
            return new TNode(NIL, NIL); // 目标节点在通过旋转操作称为叶子节点后才移除
        } else if(t.left.key == NIL) { // 如果只有右子树，则左旋转
            t = leftRotate(t);
        } else if(t.right.key == NIL) { // 如果只有左子树，则右旋转
            t = rightRotate(t);
        } else { // 如果左右子树都有
            if(t.left.pri > t.right.pri) {
                t = rightRotate(t);
            } else {
                t = leftRotate(t);
            }
        }
        return delete(t, key); // 旋转后重新遍历树寻找目标，进行下一次递归
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
    int pri;
    TNode left, right ,parent;
    TNode(int key, int pri) {
        this.key = key;
        this.pri = pri;
    }
}
