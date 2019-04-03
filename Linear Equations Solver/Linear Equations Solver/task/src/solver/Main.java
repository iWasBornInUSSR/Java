package solver;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        double a = scanner.nextDouble();
//        double b = scanner.nextDouble();
//        double c = scanner.nextDouble();
//        double d = scanner.nextDouble();
//        double e = scanner.nextDouble();
//        double f = scanner.nextDouble();
//        double y = (f - c * d / a) / (e - b * d / a);
//        double x = (c - b * y) / a;
//        System.out.printf("%4f %4f", x, y);
        System.out.println("Start solving the equation.\n" +
                "Rows manipulation:");
        Matrix matrix = new Matrix("/home/picknick/IdeaProjects/HSproj/Linear Equations Solver/Linear Equations Solver/task/src/solver/in.txt");
        matrix.solve("/home/picknick/IdeaProjects/HSproj/Linear Equations Solver/Linear Equations Solver/task/src/solver/out.txt");
    }
}
