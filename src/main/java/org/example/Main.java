package org.example;

import java.util.Scanner;

public class Main {

    public static double S(final double x, final double eps, int n, double s) {
        n = 0;
        double a = 1 / x;
        s = a;
        do {
            n++;
            a = A(x, n, a);
            s += a;
        } while (Math.abs(a) >= eps);
        return s;
    }

    public static double A(final double x, final int n, double a) {
        double R = (2 * n - 1) / ((2 * n + 1) * Math.pow(x, 2));
        a *= R;
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x, s = 0;
        int n = 0;
        double arcth = 0;
        System.out.print("xp = ");
        double xp = scanner.nextDouble();
        System.out.print("xk = ");
        double xk = scanner.nextDouble();
        System.out.print("dx = ");
        double dx = scanner.nextDouble();
        System.out.print("eps = ");
        double eps = scanner.nextDouble();

        System.out.println("-------------------------------------------------");
        System.out.println("| " + String.format("%9s", "x") + " | " + String.format("%9s", "arcth(x)") + " | " + String.format("%9s", "S") + " | " + String.format("%9s", "n") + " |");
        System.out.println("-------------------------------------------------");

        if (Math.abs(xk) > 1 && Math.abs(xp) > 1) {
            x = xp;
            while (x <= xk) {
                s = S(x, eps, n, s);
                System.out.println(String.format("| %9.2f | %9.5f | %9.5f | %9s |", x, 0.5 * Math.log((x + 1) / (x - 1)), s, n));
                x += dx;
            }
            System.out.println("-------------------------------------------------");
        } else {
            System.out.println("x <= 1");
        }
    }
}
