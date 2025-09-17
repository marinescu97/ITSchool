package session_29_Concurrency.Homework.Matrix;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int rowsA = 500, colsA = 500;
        int rowsB = colsA, colsB = 500;

        Matrix A = Matrix.randomMatrix(rowsA, colsA, 10);
        Matrix B = Matrix.randomMatrix(rowsB, colsB, 10);

        // Single-threaded
        long start = System.currentTimeMillis();
        Matrix C1 = MatrixMultiplier.multiply(A, B);
        long end = System.currentTimeMillis();
        System.out.println("Single-threaded time: " + (end - start) + " ms");

        // Multi-threaded
        int numThreads = 4;
        start = System.currentTimeMillis();
        Matrix C2 = MatrixMultiplier.multiply(A, B, numThreads);
        end = System.currentTimeMillis();
        System.out.println("Multi-threaded time (" + numThreads + " threads): " + (end - start) + " ms");
    }
}
