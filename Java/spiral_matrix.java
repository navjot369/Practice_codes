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

    public static void spiral2(int arr[][]) {
        int rows = arr.length;
        int cols = arr[0].length;
        int total = rows * cols;

        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        int ind = 0, x = 0, y = 0;
        boolean temp[][] = new boolean[rows][cols];

        for(int i = 0; i < total; i++) {
            System.out.print(arr[x][y] + " ");
            temp[x][y] = true;
            
            int newx = x + dx[ind];
            int newy = y + dy[ind];
            if(newx < 0 || newx >= rows || newy < 0 || newy >= cols || temp[newx][newy]) {
                ind = (ind + 1) %4;
                newx = x + dx[ind];
                newy = y + dy[ind];
            }
            x = newx;
            y = newy;
        }

    }

    public static void main(String args[]){
        int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        spiral(matrix);
        System.out.println("\n---");
        spiral2(matrix);
        System.out.println();
    }
}