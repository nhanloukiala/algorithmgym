package implementation;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
  public class Grid {
    int[][] mat;
    int currentx, currenty;
    int xUpper, xLower, yUpper, yLower;
    int xDir, yDir;

    public Grid(int[][] matrix) {
      mat = matrix;
      currentx = 0; currenty = 0;
      xUpper = mat.length;
      xLower = 0;
      yLower = 0;
      yUpper = mat[0].length;
      xDir = 0;
      yDir = -1;
    }

    public void rotateClockWise90(){
      if(xDir == 0 && yDir == 1)  {
        xDir = 1;
        yDir = 0;
      }

      if(xDir == 0 && yDir == -1) {
        xDir = -1;
        yDir = 0;
      }

      if(xDir == 1 && yDir == 0){
          yDir = - 1;
          xDir = 0;
      }

      if(xDir == -1 && yDir == 0) {
          xDir = 0;
          yDir = 1;
      }
    }

    public boolean hasNext() {
      return false;
    }

    public boolean isFinished() {
      return false;
    }

    public void next(){

    }

    public int current() {
      return 0;
    }

    public void adjustBoundary(){

    }
  }

  public List<Integer> spiralOrder(int[][] matrix) {
      if(matrix == null)
        return new ArrayList<>();

      List<Integer> result = new ArrayList<>();

      Grid g = new Grid(matrix);
      while(!g.isFinished()) {
        result.add(g.current());

        if(g.hasNext()) {
          g.next();
          continue;
        }

        g.adjustBoundary();
        g.rotateClockWise90();

        if(g.hasNext()) g.next();
      }

      return result;
  }
}
