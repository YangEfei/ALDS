package ALDS1_7_A;

import java.util.Scanner;

class Node {
   private int parent;
   private int left;
   private int right;

   public Node(int parent, int left, int right) {
       this.parent = parent;
       this.left = left;
       this.right = right;
   }
   public void setLeft(int left) {
       this.left = left;
   }
   public void setRight(int right) {
       this.right = right;
   }
   public void setParent(int parent) {
       this.parent = parent;
   }
   public int getParent() {
       return this.parent;
   }
   public int getLeft() {
       return this.left;
   }
   public int getRight() {
       return this.right;
   }
}
public class Main {
    static final int NIL = -1;
    static final int MAX = 100005;
    static Node[] T = new Node[MAX];
    static int n;
    static int D[] = new int[MAX];

    public static void main(String[] args){
        int left = 0;

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            T[i] = new Node(NIL, NIL, NIL); // 初始化节点
        }
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            int childrenSize = scanner.nextInt();
            for (int j = 0; j < childrenSize; j++) {
                int child = scanner.nextInt();
                // 左子右兄弟
                if (j == 0) {
                    T[number].setLeft(child);
                } else {
                    T[left].setRight(child);
                }
                left = child;
                T[child].setParent(number);
            }
        }
        scanner.close();
        // 求各节点的深度
        for ( int i = 0; i < n; i++) {
            D[i] = getDepth(i);
        }

        for (int i = 0; i < n; i++) {
            print(i);
        }
    }

    static int getDepth(int number) {
        int d = 0;
        while(T[number].getParent() != NIL) {
            number = T[number].getParent();
            d ++;
        }
        return d;
    }

    static void print(int number) {
        System.out.print("node " + number + ": " + "parent = " + T[number].getParent() + ", " + "depth = " + D[number] + ", ");

        if (T[number].getParent() == NIL) {
            System.out.print("root, ");
        } else if (T[number].getLeft() == NIL) {
            System.out.print("leaf, ");
        } else {
            System.out.print("internal node, ");
        }

        System.out.print("[");

        for (int i = 0, c = T[number].getLeft(); c != NIL; i++, c = T[c].getRight()){
            if(i != 0) {
                System.out.print(", ");
            }
            System.out.print(c);
        }

        System.out.println("]");
    }
}
