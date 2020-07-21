package ALDS1_4_C;

import java.util.Scanner;

public class Main {
    private int m;  // mod
    private String[] H;

    public Main() {
        this.m = 1046527; // 大于1000000的质数
        this.H = new String[m];
    }

    public static void main(String[] args) {
        Main test = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String cmd = in.next();
            String str = in.next();

            if(cmd.equals("insert")) test.insert(str);
            else {
                if(test.find(str)) System.out.println("yes");
                else System.out.println("no");
            }
        }
        // MLE
        // for (int i = 0; i < n; i++) {
        //            String[] cmd = in.nextLine().split(" ");
        //            switch (cmd[0]) {
        //                case "insert":
        //                    test.insert(cmd[1]);
        //                    break;
        //                case "find":
        //                    if (test.find(cmd[1])) {
        //                        System.out.println("yes");
        //                    } else {
        //                        System.out.println("no");
        //                    }
        //                    break;
        //            }
        //        }
    }

    public int getChar(char ch) {
        switch (ch) {
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            case 'T':
                return 4;
            default:
                return 0;
        }
    }

    public int getKey(String str) {
        int sum = 0, p = 1;
        for (int i = 0; i < str.length(); i++) {
            sum += p * getChar(str.charAt(i));
            p *= 5;
        }
        return sum;
    }

    public int h1(int key) {
        return key % m; // 令m为质数
    }

    public int h2(int key) {
        return 1 + (key % (m - 1)); // 令h2为一个小于m的值，避免无法生成下标（h2和h1的模数应互质）
    }

    public void insert(String str) {
        int key = getKey(str);
        int h;
        for (int i = 0; i < 1000000; i++) {
            h = (h1(key) + i * h2(key)) % m;
            if (H[h] == null) {
                H[h] = str;
                break;
            } else continue;
        }
    }

    public boolean find(String str) {
        int key = getKey(str);
        int h;
        boolean flag = false;
        for (int i = 0; i < 1000000; i++) {
            h = (h1(key) + i * h2(key)) % m;
            if (H[h] == null) {
                flag = false;
                break;
            } else if (H[h].equals(str)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}