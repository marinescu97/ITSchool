package session_29_Concurrency.Homework.Matrix;

public class MatrixMultiplier {
    // Single-threaded
    public static Matrix multiply(Matrix firstMatrix, Matrix secondMatrix) throws InterruptedException {
        return multiply(firstMatrix, secondMatrix, 1);
    }

    // Multi-threaded
    public static Matrix multiply(Matrix firstMatrix, Matrix secondMatrix, int numThreads) throws InterruptedException {
        validateMultiplication(firstMatrix, secondMatrix);

        Matrix result = new Matrix(firstMatrix.getRows(), secondMatrix.getCols());

        Thread[] threads = new Thread[numThreads];
        int rowsPerThread = (int) Math.ceil((double) firstMatrix.getRows() / numThreads);

        for (int t = 0; t < numThreads; t++) {
            int startRow = t * rowsPerThread;
            int endRow = Math.min(startRow + rowsPerThread, firstMatrix.getRows());

            threads[t] = new Thread(new MatrixMultiplierTask(firstMatrix, secondMatrix, result, startRow, endRow));
            threads[t].start();
        }

        for (Thread thread : threads) thread.join();

        return result;
    }

    private static void validateMultiplication(Matrix firstMatrix, Matrix secondMatrix) {
        if (firstMatrix.getCols() != secondMatrix.getRows()) {
            throw new IllegalArgumentException("The number of columns in the first matrix must be equal to the number of rows in the second matrix.");
        }
    }
}
