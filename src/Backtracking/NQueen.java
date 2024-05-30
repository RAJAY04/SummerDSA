package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        List<List<String>> ans  = solveNQueens(5);
        printPretty(ans);
    }
    static List<List<String>> res;
    public static List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        List<StringBuilder> board = createBoard(n);
        backtrack(board,0,0,n);
        return res;

    }

    public static List<String> modifyBoard(List<StringBuilder> board){
        List<String> newBoard = new ArrayList<>();
        for(int i = 0 ; i < board.size() ; i++){
            newBoard.add(board.get(i).toString());
        }
        return newBoard;
    }
    public static void backtrack(List<StringBuilder> board,int r, int c, int n){
        if(n == 0){
            res.add(new ArrayList<>(modifyBoard(board)));
            return;
        }

        for(int i = 0 ; i < board.size(); i++){
            if(isSafe(board,r,i,n)){
                board.get(r).setCharAt(i,'Q');
                backtrack(board,r + 1,0,n - 1);
                board.get(r).setCharAt(i,'.');
            }
        }
    }

    public static List<StringBuilder> createBoard(int n){
        List<StringBuilder> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            sb.append(".");
        }
        for(int i = 0; i < n ; i++){
            board.add(new StringBuilder(sb));
        }
        return board;
    }
    public static boolean isSafe(List<StringBuilder> board , int r, int c, int n){
        if(n == board.size())return true;
        int row = r;
        int col = c;

        while(row >= 0){
            if(board.get(row--).charAt(col) == 'Q')return false;
        }

        row = r;
        col = c;
        while(col >= 0 && row >= 0){
            if(board.get(row--).charAt(col--) == 'Q')return false;
        }

        row = r;
        col = c;
        while(col < board.size() && row >= 0){
            if(board.get(row--).charAt(col++) == 'Q')return false;
        }

        return true;
    }
    public static void printPretty(List<List<String>> solutions) {
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println(); // Add a blank line between solutions
        }
    }
}
