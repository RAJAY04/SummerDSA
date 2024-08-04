package Graphs.ShortestPathAlgosAndProblms;

public class FloidWarshall {
    public static void main(String[] args) {
        int[][] matrix = {{0, 5, 1000, 10},
                {1000, 0, 3, 1000},
                {1000, 1000, 0, 1},
                {1000, 1000, 1000, 0}};
        shortest_distance(matrix);
    }

    public static void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
        for(int i = 0 ;  i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(matrix[i][j] == -1)matrix[i][j] = (int)(1e9);
                if(i == j)matrix[i][j] = 0;
            }
        }

        for(int k = 0; k < n; k++){
            for(int i = 0 ; i < n; i++){
                for(int j = 0 ; j < n ;j++){
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for(int i = 0 ;  i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(matrix[i][j] == (int)(1e9))matrix[i][j] = -1;
            }
        }
    }
}
