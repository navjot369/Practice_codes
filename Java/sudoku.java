public class sudoku {
    public static boolean isSafe(int sudoku[][], int num, int row, int col) {
        //Checking for row and columns.
        for(int i = 0; i < 9; i++) {
            if(sudoku[row][i] == num) {
                return false;
            }
            if(sudoku[i][col] == num) {
                return false;
            }
        }

        //Checking for grid.
        int rowStart = 3 * (row / 3);
        int colStart = 3 * (col / 3);
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(sudoku[rowStart + i][colStart + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean solver(int sudoku[][], int row, int col) {
        if(row == 9){
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++){
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }
        if(col == 9){
            return solver(sudoku, row + 1, 0);
        }
        if(sudoku[row][col] != 0) {
            return solver(sudoku, row, col + 1);
        }
        for(int i = 1; i < 10; i++){
            if(isSafe(sudoku, i, row, col)){
                sudoku[row][col] = i;
                if(solver(sudoku, row, col + 1)) {
                    return true;
                }
                else{
                    sudoku[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int sudoku[][] = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        // int sudoku[][] = new int[9][9];
        System.out.println("\n" + solver(sudoku, 0, 0));
    }
}
