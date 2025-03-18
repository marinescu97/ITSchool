package session_5_java_flow_control.Homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

record Cell(int row, int col) {

    @Override
    public String toString() {
        return String.format("(%d %d)", row, col);
    }
}

public class Maze {
    private char[][] maze;
    private final int[] rowDirs = {-1, 1, 0, 0};
    private final int[] colDirs = {0, 0, -1, 1};

    public Maze(char[][] maze) {
        this.maze = maze;
    }

    public Maze(String fileName) {
        try {
            this.maze = readFromFile(fileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private char[][] readFromFile(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        String line;
        List<String[]> lines = new ArrayList<>();

        while ((line = fileReader.readLine()) != null) {
            lines.add(line.trim().split(" "));
        }

        int rows = lines.size();
        int cols = lines.getFirst().length;
        char[][] charArr = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
             for (int j = 0; j < cols; j++){
                 charArr[i][j] = lines.get(i)[j].charAt(0);
             }
        }

        fileReader.close();

        return charArr;
    }

    private Cell getStart(){
        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze[i].length; j++){
                if (maze[i][j] == 'S')
                    return new Cell(i, j);
            }
        }
        return null;
    }

    private Cell getEnd() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'E') {
                    return new Cell(i, j);
                }
            }
        }
        return null;
    }

    public void getPath(){
        Cell start = getStart();
        Cell end = getEnd();

        if (start == null){
            System.out.println("No start found.");
        } else if (end == null) {
            System.out.println("No end found.");
        } else {
            findPath(start, end);
        }
    }

    private void findPath(Cell start, Cell end){
        int rows = maze.length;
        int cols = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start.row(), start.col()});

        boolean[][] visited = new boolean[rows][cols];
        visited[start.row()][start.col()] = true;

        Map<String, int[]> parentMap = new HashMap<>();

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            if (row == end.row() && col == end.col()) {
                markPath(parentMap, start, end);
            } else {
                for (int i = 0; i < 4; i++) {
                    int newRow = row + rowDirs[i];
                    int newCol = col + colDirs[i];

                    if (isValidMove(newRow, newCol, visited)) {
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol});
                        parentMap.put(newRow + "," + newCol, current);
                    }
                }
            }
        }
        System.out.println("No path found.");
    }

    private boolean isValidMove(int row, int col, boolean[][] visited) {
        int rows = maze.length;
        int cols = maze[0].length;
        return row >= 0 && row < rows && col >= 0 && col < cols && maze[row][col] != '1' && !visited[row][col];
    }

    private void markPath(Map<String, int[]> parentMap, Cell start, Cell end) {
        char[][] result = copyChar();

        int[] current = new int[]{end.row(), end.col()};

        // Reconstruct the path by following the parent map and mark with '*'
        while (current[0] != start.row() || current[1] != start.col()) {
            current = parentMap.get(current[0] + "," + current[1]);
            if (result[current[0]][current[1]] != 'S'){
                result[current[0]][current[1]] = '*';
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char[] row : result){
            for (char cell : row){
                sb.append(cell).append(' ');
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private char[][] copyChar(){
        char[][] result = new char[maze.length][maze[0].length];

        for (int i = 0; i < result.length; i++){
            System.arraycopy(maze[i], 0, result[i], 0, result[i].length);
        }

        return result;
    }
}
