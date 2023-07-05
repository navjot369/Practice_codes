public class diagonal_sum {
    public static int sum_diag(int[][] matrix){
        int sum = 0;
        int len = matrix.length;
        for(int i=0; i<len; i++){
            sum += matrix[i][i];
            sum += matrix[i][len-i-1];
        }
        if(len %2 != 0){
            int mid = (int)len/2;
            sum -= matrix[mid][mid];
        }
        return sum;
    }
    public static void main(String args[]){
        int matrix[][] = {{1, 2, 3, 4}, {2, 3, 4, 5}, {4, 5, 2, 1}, {1, 8, 9, 10}};
        int ans = sum_diag(matrix);
        System.out.println("Sum of all the diagonal elements are " + ans);
    }
}
