package solver;

public class Main {
    public static void main(String[] args) {
        if (args.length < 4)
            return;
        if (args[0].equals("-in")) {
            Matrix matrix = new Matrix(args[1]);
            System.out.println("Start solving the equation.\n" +
                    "Rows manipulation:");
            if(args[2].equals("-out"))
            matrix.solve(args[3]);
        }
    }
}
