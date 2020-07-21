package ALDS1_1_C;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
            if (isPrime(num[i])) count++;
        }
        System.out.println(count);
    }

    public static boolean isPrime(int num) {
        if (num == 2 || num == 3) return true;  // 两个较小的数另外处理
        if (num % 6 != 1 && num % 6 != 5) return false;  // 不在6的倍数两侧的一定不是质数
        int tmp = (int) Math.sqrt(num);
        for(int i = 5; i <= tmp; i+=6) { // 在6的倍数两侧的也可能不是质数
            if(num % i ==0 || num%(i+2) == 0)
                return false;
        }
        // 排除所有，剩余的是质数
        return true;
    }
}
