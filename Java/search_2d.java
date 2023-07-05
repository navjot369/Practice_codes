public class search_2d {
    public static void stair_case(int[][] matrix, int tar) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i <= m - 1 && j >= 0) {
            if(matrix[i][j] == tar){
                System.out.println("(" + i + ", " + j +")");
                return;
            }
            else if(matrix[i][j] > tar){
                j--;
            }
            else {
                i++;
            }
        }
        System.out.println("Target not found");
    }
    public static void main(String args[]){
        int matrix[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        for(int i=0 ; i<3; i++){
            for(int j=0; j<4; j++){
                System.out.print(matrix[i][j] + ">>  ");
                stair_case(matrix, matrix[i][j]);
            }
        }
        stair_case(matrix, 111);
    }
}