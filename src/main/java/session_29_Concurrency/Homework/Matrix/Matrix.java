package session_29_Concurrency.Homework.Matrix;

import java.util.Random;

public class Matrix {
    private final int[][] data;
    private final int rows;
    private final int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    public Matrix(int[][] data) {
        this.data = data;
        this.rows = data.length;
        this.cols = data[0].length;
    }

    public static Matrix randomMatrix(int rows, int cols, int maxValue) {
        Matrix matrix = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix.data[i][j] = new Random().nextInt(maxValue + 1);
            }
        }

        return matrix;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getCellValue(int row, int col) {
        return data[row][col];
    }

    public void setCellValue(int row, int col, int value) {
        data[row][col] = value;
    }

    public void print() {
        for (int[] row : data) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
