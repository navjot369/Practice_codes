public class KnightsTour {
    public static void printBoard(int board[][]) {
        int len = board.length;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solver(int board[][], int row, int col, int num) {
        if(num == board.length * board.length) {
            printBoard(board);
            return true;
        }
        if(row < 0 || col < 0 || row >= board.length || col >= board.length) {
            return false;
        }
        if(row == 0 && col == 0 && num != 0){
            return false;
        }
        if(board[row][col] != 0) {
            return false;
        }
        else {
            board[row][col] = num;
        }
        // System.out.println(row + " " + col + " " + num);
        if(solver(board, row + 2, col + 1, num + 1)) return true;
        if(solver(board, row + 1, col + 2, num + 1)) return true;
        if(solver(board, row - 1, col + 2, num + 1)) return true;
        if(solver(board, row - 2, col + 1, num + 1)) return true;
        if(solver(board, row - 2, col - 1, num + 1)) return true;
        if(solver(board, row - 1, col - 2, num + 1)) return true;
        if(solver(board, row + 1, col - 2, num + 1)) return true;
        if(solver(board, row + 2, col - 1, num + 1)) return true;
        board[row][col] = 0;
        return false;
    }
    public static void main(String args[]) {
        int size = 8;
        int board[][] = new int[size][size];
        solver(board, 0, 0, 0);
    }
}
