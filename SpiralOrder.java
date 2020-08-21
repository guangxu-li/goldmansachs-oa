import java.util.ArrayList;
import java.util.List;

class SpiralOrder {
    private boolean isPrime(int n) {
        if (n <= 3) {
            return n > 1;
        }

        // improve performance
        if ((n - 1) % 6 != 0 && (n + 1) % 6 != 0) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> nums = new ArrayList<>();

        if (matrix.length == 0 || matrix.length == 0) {
            return nums;
        }

        int[] rowDirs = new int[] {0, 1, 0, -1};
        int[] colDirs = new int[] {1, 0, -1, 0};

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0, row = 0, col = 0, dir = 0; i < rows * cols; i++) {
            if (isPrime(matrix[row][col])) {
                nums.add(matrix[row][col]);
            }
            visited[row][col] = true;

            int nextRow = row + rowDirs[dir];
            int nextCol = col + colDirs[dir];

            if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols
                    && !visited[nextRow][nextCol]) {
                row = nextRow;
                col = nextCol;
            } else {
                dir = (dir + 1) % 4;
                row += rowDirs[dir];
                col += colDirs[dir];
            }
        }

        return nums;
    }
}
