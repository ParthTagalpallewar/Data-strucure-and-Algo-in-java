package Recursions.BackTracking;

public class N_Queens {
    
    public boolean is_attacked(int col, int row, int[][] board, int N) {

        if(checkRow(col, row, board, N)) return true;
        
        if(checkCol(col, row, board, N)) return true;

        if(Type1DiagonalCheck(col, row, board, N)) return true;

        if(Type2DiagonalCheck(col, row, board, N)) return true;

        return false;

    }

    public boolean checkRow(int col, int row, int[][] board, int N){

        for(int i = 0; i < N; i++){
            if(board[row][i] == 1) return true;
        }

        return false;

    }

    public boolean checkCol(int col, int row, int[][] board, int N){

        for(int i = 0; i < N; i++){
            if(board[i][col] == 1) return true;
        }

        return false;
    } 

    //return true if queen in danger
    public boolean Type1DiagonalCheck(int col, int row, int[][] board, int N){

        //System.out.println("Checking TYPE 1 ");
        int p = col, q = row;

        //first check upper left side value
        while(p >= 0 && q >= 0){
            //System.out.println("check upper left diagonal (" + p + ", " + q + ")");
            if(board[q][p] == 1) return true;

            p -= 1;
            q -= 1;
        }

        p = col+1;
        q = row+1;

        //check lower right side values
        while(p < N && q < N){

            //System.out.println("check below right diagonal (" + p + ", " + q + ")");

            if(board[q][p] == 1) return true;

            p += 1;
            q += 1;
        }

        return false;
    }
   
    //return true if queen in danger
    public boolean Type2DiagonalCheck(int x, int y, int[][] board, int N){

        //System.out.println("Checking Type 2 ");
        int p = x, q = y;

        while(p < N && q >= 0){
            //System.out.println("check bottom left diagonal (" + p + ", " + q + ")");
            if(board[q][p] == 1 && p != x && q != y) return true;

            p += 1;
            q -= 1;
        }

        p = x-1;
        q = y+1;

        while(p >= 0 && q < N){
            //System.out.println("check upper right diagonal (" + p + ", " + q + ")");
            if (board[q][p] == 1 && p != x && q != y) return true;

            p -= 1;
            q += 1;
        }


        return false;
    }

    public boolean place_queens(int[][] board, int queen, int N){
        if(queen == 0) return true;

        for(int row= 0; row< N; row++){
            for(int col= 0; col< N; col++){

                if(is_attacked(col, row, board, N)) continue;
            
                board[row][col] = 1;
                System.out.println("Set ["+row+", "+col+"]");
                if(place_queens(board, queen-1, N)){
                    return true;
                }


                board[row][col] = 0;
                System.out.println("UnSet [" + row + ", " + col + "]");
            
            }
        }

        
        return false;


    }

    public static void main(String[] args) {
        
        N_Queens instance = new N_Queens();
        int N = 4;
        int[][] board = new int[N][N];
        // board[0][1] = 1;
        // print_board(board, N);

        // boolean isSuccess = instance.is_attacked(2, 1, board, N);
        // System.out.println(isSuccess);
        boolean isSuccess = instance.place_queens(board, N, N);
        System.out.println(isSuccess);

        print_board(board, N);
    }
       
    public static void print_board(int[][] board, int N) {

        System.out.println();

        for (int i = 0; i < N; i++) {
            for (int j= 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

}
