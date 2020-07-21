package ALDS1_3_D;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        Stack<Integer> s1 = new Stack<>();
        Stack<Pair<Integer, Integer>> s2 = new Stack<>();
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\\') {
                s1.push(i);
            } else if (s.charAt(i) == '/' && !s1.isEmpty()) {
                int j = s1.pop();  // 取栈顶元素

                sum += i - j; // 求总面积

                /* 求各积水处的横截面积 begin */
                int a = i - j;
                while (!s2.isEmpty() && s2.peek().getKey() > j) { // 该横截面上还有其他积水
                    a += s2.pop().getValue(); // 合并成新形成的面积
                }
                s2.push(new Pair<>(j, a));
                /* 求各积水处的横截面积 end */
            }
        }
        // 输出
        System.out.println(sum);
        int size = s2.size();
        System.out.print(size);

        Stack<Integer> s3 = new Stack<>();
        for (int i = 0; i < size; i++) {
            s3.push(s2.pop().getValue());
        }

        for (int i = 0; i < size; i++) {
            System.out.print(" " + s3.pop());
        }
        System.out.println();
    }
}

class Pair<T1 ,T2> {
    private T1 key;
    private T2 value;
    public Pair(T1 key, T2 value) {
        this.key = key;
        this.value = value;
    }

    public T2 getValue() {
        return this.value;
    }

    public T1 getKey() {
        return this.key;
    }
}