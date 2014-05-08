package chapter1;

/**
 * Given an image represented by an N*N matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
 * place?
 * 
 * @author Dong Jiang
 * 
 */
public class Q1_6 {

    /**
     * The ratation can be performed in layers, where you can perform a cycle
     * swap on the edges on each layer. In the first loop, we rotate the first
     * layer(outermost edges). We rotate the edges by doing a four-way swap
     * first on the corners, then on the element clockwise from the edges, then
     * on the element three steps away.
     * 
     * @param a
     * @param n
     */
    public static void rotateMatrix(int[][] a, int n) {
        for (int i = 0; i < n / 2; i++) {
            int first = i;
            int last = n - 1 - i;
            for (int j = first; j < last; j++) {
                int offset = j - first;
                int tmp = a[first][j];
                a[first][j] = a[last - offset][first];
                a[last - offset][first] = a[last][last - offset];
                a[last][last - offset] = a[j][last];
                a[j][last] = tmp;
            }

        }

    }

    public static void rotateMatrix2(int[][] a, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = a[i][j];
                a[i][j] = a[i][n - 1 - j];
                a[i][n - 1 - j] = tmp;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotateMatrix(matrix, matrix.length);
        printMatrix(matrix);
        rotateMatrix2(matrix, matrix.length);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] m) {
        int len = m.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++)
                System.out.print(m[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

}
