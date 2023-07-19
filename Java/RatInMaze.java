public class RatInMaze {
    public static void solver(int arr[][], int row, int col, int temp[][]) {
        int len = arr.length;
        if(row == -1 || row == len || col == -1 || col == len){
            return;
        }
        if(row == len - 1 && col == len - 1) {
            temp[row][col] = 1;
            for(int i = 0; i < len; i++){
                for(int j = 0; j < len; j++){
                    System.out.print(temp[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        if(temp[row][col] == 1) {
            return;
        }
        temp[row][col] = 1;
        if(row > 0 && arr[row - 1][col] == 1) {
            solver(arr, row - 1, col, temp);
        }
        if(row < len - 1 && arr[row + 1][col] == 1) {
            solver(arr, row + 1, col, temp);
        }
        if(col < 0 && arr[row][col - 1] == 1){
            solver(arr, row, col - 1, temp);
        }
        if(col < len - 1 && arr[row][col + 1] == 1) {
            solver(arr, row, col + 1, temp);
        }
        temp[row][col] = 0;
    }

    public static void main(String args[]) {
        int arr[][] = { {1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solver(arr, 0, 0, new int[arr.length][arr.length]);
    }
}
