public class spiral_matrix {
    public static void spiral(int mat[][]){
        int sr = 0;
        int sc = 0;
        int er = mat.length-1;
        int ec = mat[0].length-1;
        while(true){
            for(int j=sc; j<=ec; j++){
                System.out.print(mat[sr][j] + " ");
            }
            sr++;
            if(sr>er)break;
            for(int i=sr; i<=er; i++){
                System.out.print(mat[i][ec] + " ");
            }
            ec--;
            if(sc>ec)break;
            for(int j=ec; j>=sc; j--){
                System.out.print(mat[er][j] + " ");
            }
            er--;
            if(sr>er)break;
            for(int i=er; i>=sr; i--){
                System.out.print(mat[i][sc] + " ");
            }
            sc++;
            if(sc>ec)break;
        }
    }
    public static void main(String args[]){
        int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        spiral(matrix);
    }
}