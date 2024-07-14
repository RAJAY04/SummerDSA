package Graphs.BFSandDFS;

import java.util.Arrays;

public class SurroundRegions {
    public static void main(String[] args) {
        char[][] board = {
                {'O', 'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O'}
        };

        solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0,visited);
            }
            if (board[i][m - 1] == 'O') {
                dfs(board, i, m - 1,visited);
            }
        }

        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j,visited);
            }
            if (board[n - 1][j] == 'O') {
                dfs(board, n - 1, j,visited);
            }
        }

        for(int i = 1 ; i < n - 1;i++){
            for(int j = 1 ; j < m - 1 ; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public static void dfs(char[][] board,int r, int c, boolean[][] visited){
        if(board[r][c] == 'X')return;
        visited[r][c] = true;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        for(int i = 0 ; i < 4; i++){
            int row = r + dx[i];
            int col = c + dy[i];
            if((row >= 0 && col >= 0 && row < board.length && col < board[0].length) && !visited[row][col]){
                dfs(board,row,col,visited);

            }
        }
    }
//    public static void solve(char[][] board) {
//        int n = board.length;
//        int m = board[0].length;
//
//        boolean[][] visited = new boolean[n][m];
//        for(int i = 0 ; i < n ;i++){
//            for(int j = 0; j < m ; j++){
//                if(board[i][j] == 'O' && !visited[i][j]){
//                    if(dfs(board,i,j,visited)){
//                        board[i][j] = 'X';
//                    }
//                }
//            }
//        }
//    }
//    public static boolean dfs(char[][] board,int r , int c , boolean[][] visited){
//        if((r == 0 || r == board.length - 1 || c == 0 || c == board[0].length - 1) && board[r][c] == 'O'){
//            return false;
//        }else if(board[r][c] == 'X')return true;
//
//        visited[r][c] = true;
//        int[] dx = {-1,0,1,0};
//        int[] dy = {0,1,0,-1};
//        boolean res = true;
//        for(int i = 0 ; i < 4; i++){
//            int row = r + dx[i];
//            int col = c + dy[i];
//            if(!visited[row][col] && row >= 0 && col >= 0 && row < board.length && col < board[0].length){
//                if(!dfs(board,row,col,visited)){
//                    res = false;
//                    break;
//                }
//            }
//        }
//        if(res){
//            board[r][c] = 'X';
//            return true;
//        }
//        return false;
//    }//this algo dosent work properly
}
