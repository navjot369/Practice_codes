public class N_queens {
    static int count = 0;
    public static void printBoard(char board[][]) {
        System.out.println("------------------------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void placeQueens(char board[][], int row) {
        if(row == board.length){
            count++;
            printBoard(board);
            return;
        }
        for(int j = 0; j < board.length; j++) {
            if(isSafe(board, row, j)) {
                board[row][j] = 'Q';
                placeQueens(board, row + 1);
                board[row][j] = 'X';
            }
            
        }
    }

    //Function to print only one solution.
    // public static boolean placeQueens(char board[][], int row) {
    //     if(row == board.length){
    //         count++;
    //         printBoard(board);
    //         return true;
    //     }
    //     for(int j = 0; j < board.length; j++) {
    //         if(isSafe(board, row, j)) {
    //             board[row][j] = 'Q';
    //             if(placeQueens(board, row + 1)) {
    //                 return true;
    //             }
    //             board[row][j] = 'X';
    //         }
    //     }
    //    return false;
    // }

    public static boolean isSafe(char board[][], int row, int col) {
        int len = board.length;
        //For it's  column.
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        //For it's falling diagonal.
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        //For it's rising diagonal.
        for(int i = row - 1, j = col + 1; i >= 0 && j < len; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        int n = 100;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        placeQueens(board, 0);
        System.out.println("\nTotal number of possible solution: " + count);
    }

}
