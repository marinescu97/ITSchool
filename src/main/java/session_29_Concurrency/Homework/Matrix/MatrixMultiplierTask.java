package session_29_Concurrency.Homework.Matrix;

public record MatrixMultiplierTask(Matrix firstMatrix, Matrix secondMatrix, Matrix result, int startRow,
                                   int endRow) implements Runnable {

    @Override
    public void run() {
        for (int i = startRow; i < endRow; i++) {
            for (int j = 0; j < secondMatrix.getCols(); j++) {
                int sum = 0;
                for (int k = 0; k < firstMatrix.getCols(); k++) {
                    sum += firstMatrix.getCellValue(i, k) * secondMatrix.getCellValue(k, j);
                }
                result.setCellValue(i, j, sum);
            }
        }
    }
}
