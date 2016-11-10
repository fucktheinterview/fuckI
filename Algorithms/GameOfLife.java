//https://discuss.leetcode.com/topic/29054/easiest-java-solution-with-explanation
// constant space

public class Solution {
public void gameOfLife(int[][] board) {
    if(board == null || board.length == 0) return;
    int m = board.length, n = board[0].length;

    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            int lives = liveNeighbors(board, m, n, i, j);

            // In the beginning, every 2nd bit is 0;
            // So we only need to care about when the 2nd bit will become 1.
            if(board[i][j] == 1 && lives >= 2 && lives <= 3) {  
                board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
            }
            if(board[i][j] == 0 && lives == 3) {
                board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
            }
        }
    }

    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            board[i][j] >>= 1;  // Get the 2nd state.
        }
    }
}

public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
    int lives = 0;
    for(int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) { // **** i +1 combine with  m -1 and <=
        for(int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
            lives += board[x][y] & 1;
        }
    }
    lives -= board[i][j] & 1;
    return lives;
}
}


// my version with wrapping boarding

public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length ==0 || board[0].length ==0) return;
        
        for(int i =0; i< board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                updateCell(board, i, j);
            }
        }
        
        for(int i = 0; i< board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >>1;
            }
        }
        
    }
    
    private void updateCell(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int count = (board[(i-1 + m)%m][(j- 1 +n)%n] & 1) +
                    (board[(i-1 + m)%m][j] & 1) +
                    (board[(i-1 + m)%m][(j + 1)%n] & 1 )+    
                    (board[i][(j- 1 +n)%n] & 1)  + 
                    (board[i][(j + 1)%n] & 1 ) +  
                    (board[(i +1)%m][(j - 1 + n)%n] & 1) +
                    (board[(i + 1)%m][j] & 1 )+
                    (board[(i + 1)%m][(j + 1)%n] & 1);

        if( ( board[i][j] == 1 && (count == 2 || count ==3) ) || ( board[i][j] == 0 && count == 3) ) {
            board[i][j] += (1 << 1);
        } 
    }
}


//my own unwrapper version

public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length ==0 || board[0].length ==0) return;
        
        for(int i =0; i< board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                updateCell(board, i, j);
            }
        }
        
        for(int i = 0; i< board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >>1;
            }
        }
        
    }
    
    private void updateCell(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int count = ((i > 0 && j >0) ? (board[(i-1 + m)%m][(j- 1 +n)%n] & 1) : 0 )+
                    ((i > 0) ? (board[(i-1 + m)%m][j] & 1) : 0 ) +
                    ((i > 0 && (j+1) < n) ? (board[(i-1 + m)%m][(j + 1)%n] & 1 ) : 0 ) +    
                    ( (j > 0) ? (board[i][(j- 1 +n)%n] & 1) : 0  ) + 
                    (((j+1) < n) ? (board[i][(j + 1)%n] & 1 ) : 0 ) +  
                    (((i+1) < m && j >0) ? (board[(i +1)%m][(j - 1 + n)%n] & 1) : 0  )+
                    ( ((i+1) < m) ? (board[(i + 1)%m][j] & 1 ) : 0 ) +
                    ( ((i+1) < m && (j+1) < n) ?(board[(i + 1)%m][(j + 1)%n] & 1) : 0 );

        if( ( board[i][j] == 1 && (count == 2 || count ==3) ) || ( board[i][j] == 0 && count == 3) ) {
            board[i][j] += (1 << 1);
        } 
    }
}
