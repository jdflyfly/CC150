package chapter1;

/**
 * Write an algorithm such that if an element in an M*N matrix is 0, its entire
 * row and column is set to 0;
 * 
 * @author Dong Jiang
 * 
 */
public class Q1_7 {

    /**
     * We keep track in two arrays all the rows with zeros and all the columns
     * with zeros, and then we make a second pass of the matrix and set a cell
     * to zero if its row or column is zero. we need O(m+n) space;
     * 
     * @param matrix
     */
    public static void setZeros(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++)
            if (rows[i] == 1)
                for (int j = 0; j < n; j++)
                    matrix[i][j] = 0;

        for (int j = 0; j < n; j++)
            if (cols[j] == 1)
                for (int i = 0; i < m; i++)
                    matrix[i][j] = 0;

    }

    /**
     * we can reduce the space to O(1). We only use two variables to keep track
     * in the first row and the first column whether they have zeros. For the
     * other rows and columns, we keep track the info in the first row or the
     * first column.
     * 
     * @param matrix
     */
    public static void setZeros2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int m = matrix.length;
        int n = matrix[0].length;

        int i, j;
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;
        for (i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }
        for (i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                isFirstRowZero = true;
                break;
            }

        }

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }

            }

        }

        for (i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (j = 0; j < n; j++)
                    matrix[i][j] = 0;
            }

        }

        for (i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (j = 0; j < m; j++)
                    matrix[j][i] = 0;
            }
        }

        if (isFirstRowZero) {
            for (i = 0; i < n; i++)
                matrix[0][i] = 0;
        }

        if (isFirstColZero) {
            for (i = 0; i < m; i++)
                matrix[i][0] = 0;
        }

        return;

    }

    private static void printMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 0, 2 }, { 3, 1, 2 }, { 2, 1, 0 }, { 1, 4, 2 } };
        printMatrix(matrix);
        setZeros2(matrix);
        printMatrix(matrix);
    }

}
