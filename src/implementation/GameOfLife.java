package implementation;

class GameOfLife {
  int countNeighborhood(int[][] board, int x, int y) {
    int lowerX = x - 1 >= 0 ? x - 1 : x;
    int lowerY = y - 1 >= 0 ? y - 1: y;
    int upperX = x + 1 < board.length ? x + 1 : x;
    int upperY = y + 1 < board[0].length ? y + 1 : y;
    int result = 0;

    for(int i = lowerX ; i <= upperX; i++) {
      for(int j = lowerY; j <= upperY; j++) {
        if(x == 1 && y == 0){
          System.out.println(lowerX + " " + lowerY + " " + upperX + " " + upperY + " " + board[i][j]);
        }
        result += board[i][j] % 2;
      }
    }

    return result;
  }
  public void gameOfLife(int[][] board) {
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        int neighbor = countNeighborhood(board, i, j) - board[i][j];
        if(board[i][j] == 1 && (neighbor < 2 || neighbor > 3)) {board[i][j] = 3; continue;}
        if(board[i][j] == 1 && neighbor <= 3 && neighbor >= 2) {board[i][j] = 5;continue;}
        if(board[i][j] == 0 && neighbor == 3) {board[i][j] = 4;continue;}
        board[i][j] = 2;
      }
    }

    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        board[i][j] = board[i][j] / 4;
      }
    }
  }
}
