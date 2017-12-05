/* FillShape fills a shape represented with 1 values in a double dimensional array of integers. */

public class MatrixUtil {

    public static void runFillShape() {

        int shape[][] = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
        };


        System.out.println("Shape before:");
        MyPrinter.printArray(shape);

        int shape_output[][] = fillShape(shape);

        System.out.println("Shape after:");
        MyPrinter.printArray(shape);
    }

    public static int[][] fillShape(int[][] matrix) {
        if(matrix == null){
            return null;
        }
        int width = matrix[0].length;
        int height = matrix.length;
        int center_width = width / 2;
        int center_height = height / 2;

        fillShapeHelper(matrix, center_width, center_height);
        return matrix;
    }

    public static int[][] fillShapeHelper(int[][] matrix, int x, int y) {
        int width = matrix[0].length;
        int height = matrix.length;

        if ( x >= 0 && y >= 0 && x < width && y < height ) {
            if (matrix[y][x] == 0) {
                matrix[y][x] = 1;
            }
        }
        if ( x+1 >= 0 && y >= 0 && x+1 < width && y < height ) {
            if(matrix[y][x+1] == 0) {
                fillShapeHelper(matrix, x + 1, y);
            }
        }
        if ( x-1 >= 0 && y >= 0 && x-1 < width && y < height ) {
            if(matrix[y][x-1] == 0 ) {
                fillShapeHelper(matrix, x - 1, y);
            }
        }
        if ( x >= 0 && y+1 >= 0 && x < width && y+1 < height ) {
            if(matrix[y+1][x] == 0) {
                fillShapeHelper(matrix, x, y + 1);
            }
        }
        if ( x >= 0 && y-1 >= 0 && x < width && y-1 < height ) {
            if(matrix[y-1][x] == 0) {
                fillShapeHelper(matrix, x, y - 1);
            }
        }
        return matrix;
    }

    public void rotateMatrix(int[][] matrix){
        /* If the matrix isn't N x N return */
        if(matrix[0].length != matrix.length){
            System.out.println("Invalid matrix");
            return;
        }
        int N = matrix.length-1;

        for(int y = 0; y < N/2; y++){
            for(int x = y; x < N-y; x++){
                int temp = matrix[y][x];
                matrix[  y][  x] = matrix[  x][N-y];
                matrix[  x][N-y] = matrix[N-y][N-x];
                matrix[N-y][N-x] = matrix[N-x][  y];
                matrix[N-x][  y] = temp;
            }
        }
    }

    public int[][] multiply(int[][] A, int[][] B){
        int[][] C = new int[A[0].length][B.length];

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B[0].length; j++){
                int temp = 0;
                for(int z = 0; z < B.length; z++){
                    temp =+ A[i][z] * B[z][j];
                }
                C[i][j] = temp;
            }
        }
        return C;
    }

}
