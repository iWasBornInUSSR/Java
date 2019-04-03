package solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    private int N;
   private Row[] rows;
    public Matrix(String filename) {
        /* file manipulation */
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            if(scanner.hasNextInt()) {
                N = Integer.parseInt(scanner.nextLine());
                rows = new Row[N];
            }
            for (int i = 0; i < N; i++){
                String[] coefLines = scanner.nextLine().split(" ");
                float[] coeffloat = new float[N + 1];
                for (int j = 0; j < coefLines.length; j++) {
                    coeffloat[j] = Float.parseFloat(coefLines[j]);
                }
                rows[i] = new Row(coeffloat);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + file.getAbsolutePath());
        }
    }
    public void solve(String filepath){
        File file = new File(filepath);
        /* first part */
        for (int i = 0; i < N; i++) {
            if (rows[i].getCoeffs()[i] != 0) {
                if (rows[i].getCoeffs()[i] != 1) {
                    float p = 1 / rows[i].getCoeffs()[i];
                    rows[i].multByNumber(p);
                    if (p == (int)p)
                    System.out.println((int)p + " * R" + (i + 1) + " -> R" + (i + 1));
                    else  System.out.println(p + " * R" + (i + 1) + " -> R" + (i + 1));
                }

                for (int j = i + 1; j < N; j++) {
                    gausMethod(i, j);
                }
            }
        }
        for (int i = N - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                gausMethod(i, j);
            }
        }
        float[] ans = new float[N];
        for (int i = 0; i < N; i++) {
            ans[i] = rows[i].getCoeffs()[N];
        }
        System.out.println("The solution is: " + Arrays.toString(ans).replace("[","(").replace("]",")"));
        System.out.println("Saved to file " + file.getName());
        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (Row row : rows) {
                printWriter.println(row.getCoeffs()[N]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + file.getAbsolutePath());
        }
    }

    private void gausMethod(int i, int j) {
        float d = -rows[j].getCoeffs()[i];
        rows[j].intercalateRow(rows[i].multByNumberNew(d));
        if(d != (int)d)
        System.out.println(d + " * R" + (i + 1) +" + R" + (j + 1) +" -> R" + (j + 1));
        else System.out.println((int)d + " * R" + (i + 1) +" + R" + (j + 1) +" -> R" + (j + 1));
    }

    public void printMatrix(){
        for (Row row : rows) {
            System.out.println(row.toString());
        }
    }
}
