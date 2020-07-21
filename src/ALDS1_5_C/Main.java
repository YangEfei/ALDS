package ALDS1_5_C;

import java.util.Scanner;

public class Main {
    static class Point {
        public double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void koch(int n, Point a, Point b) {
        if (n == 0) return;

        double th = Math.PI * 60.0 / 180.0;  // 将单位从度变为弧度

        double s_x = (2.0 * a.x + 1.0 * b.x) / 3.0;
        double s_y = (2.0 * a.y + 1.0 * b.y) / 3.0;
        double t_x = (1.0 * a.x + 2.0 * b.x) / 3.0;
        double t_y = (1.0 * a.y + 2.0 * b.y) / 3.0;
        double u_x = (t_x - s_x) * Math.cos(th) - (t_y - s_y) * Math.sin(th) + s_x;
        double u_y = (t_x - s_x) * Math.sin(th) + (t_y - s_y) * Math.cos(th) + s_y;

        Point s = new Point(s_x, s_y);
        Point t = new Point(t_x, t_y);
        Point u = new Point(u_x, u_y);

        koch(n - 1, a, s);
        System.out.println(String.format("%.8f %.8f", s.x, s.y));
        koch(n - 1, s, u);
        System.out.println(String.format("%.8f %.8f", u.x, u.y));
        koch(n - 1, u, t);
        System.out.println(String.format("%.8f %.8f", t.x, t.y));
        koch(n - 1, t, b);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Point a = new Point(0.0, 0.0);
        Point b = new Point(100.0, 0.0);

        System.out.println(String.format("%.8f %.8f", a.x, a.y));
        koch(n, a, b);
        System.out.println(String.format("%.8f %.8f", b.x, b.y));
    }
}
