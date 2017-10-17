/* FillShape fills a shape represented with 1 values in a double dimensional array of integers. */

public class FillShape {

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
        printShape(shape);

        int shape_output[][] = fillShape(shape);

        System.out.println("Shape after:");
        printShape(shape);
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

    public static void printShape(int[][] shape) {
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                System.out.print(" " + shape[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

}
