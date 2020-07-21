package ALDS1_3_A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Scanner opt = new Scanner(line);
        int num1, num2;
        Stack num = new Stack();
        while (opt.hasNext()) {
            String c = opt.next();
            if (c.equals("+")) {
                num1 = num.pop();
                num2 = num.pop();
                num.push(num1 + num2);
            } else if (c.equals("-")) {
                num1 = num.pop();
                num2 = num.pop();
                num.push(num2 - num1);
            } else if (c.equals("*")) {
                num1 = num.pop();
                num2 = num.pop();
                num.push(num1 * num2);
            } else {
                num.push(Integer.parseInt(c));
            }
        }
        System.out.println(num.pop());
    }
}

class Stack {
    int top;
    int[] stack;

    public Stack() {
        this.top = 0;
        this.stack = new int[1000];
    }

    public void push(int num) {
        this.top++;
        this.stack[top] = num;
    }

    public int pop() {
        int num = this.stack[this.top];
        this.stack[this.top] = 0;
        this.top--;
        return num;
    }
}
