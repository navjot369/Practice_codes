public class transpose {
    public static void main(String args[]){
        int matrix[][] = {{1, 2, 3, 4}, {4, 3, 2, 1}};
        int trans[][] = new int[matrix[0].length][matrix.length];
        for(int i=0; i<matrix[0].length; i++){
            for(int j=0; j<matrix.length; j++){
                trans[i][j] = matrix[j][i];
            }
        }
        for(int i=0; i<matrix[0].length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(matrix[j][i] + "  ");
            }
            System.out.println();
        }
    }
}
