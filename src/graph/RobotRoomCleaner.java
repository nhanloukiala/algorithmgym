//package graph;
//
//public class RobotRoomCleaner {
//  class Solution {
//    class Node {
//      int x, y;
//      public Node(int x, int y) {
//        this.x = x;
//        this.y = y;
//      }
//
//      public boolean equals(Object other) {
//        return ((Node)other).x == this.x && ((Node)other).y == this.y;
//      }
//
//      public int hashCode(){
//        return 1000000 * x + y;
//      }
//
//      public Node clone(){
//        return new Node(this.x, this.y);
//      }
//
//      public Node forward(Vec vec){
//        this.x += vec.x;
//        this.y += vec.y;
//        return this.clone();
//      }
//
//      public Node backward(Vec vec){
//        this.x -= vec.x;
//        this.y -= vec.y;
//        return this.clone();
//      }
//    }
//
//    class Vec {
//      int x,y;
//
//      public Vec(){
//        this.x = 1;
//        this.y = 0;
//      }
//
//      public void rotate90(){
//        int x = this.x * 0 - this.y * 1;
//        int y = this.x * 1 - this.y * 0;
//        this.x = x;
//        this.y = y;
//      }
//
//      public void rotate180(){
//        for(int i = 0 ; i < 2; i++) rotate90();
//      }
//
//      public void rotate270(){
//        for(int i = 0 ; i < 3; i++) rotate90();
//      }
//    }
//
//    public void cleanRoom(Robot robot) {
//      Node current = new Node(0,0);
//      Vec compass = new Vec();
//      HashSet<Node> visited = new HashSet<Node>();
//
//      backtrack(current, compass, robot, visited);
//    }
//
//    private void backtrack(Node current, Vec vec, Robot robot, HashSet<Node> visited) {
//      robot.clean();
//      visited.add(current.clone());
//
//      // 0
//      if(!visited.contains(current.forward(vec)) && robot.move()) {
//        backtrack(current, vec, robot, visited);
//        current.backward(vec);
//        for(int i = 0; i < 2; i++) robot.turnRight();
//        robot.move();
//        for(int i = 0; i < 2; i++) robot.turnRight();
//      }
//
//
//
//      //90
//      vec.rotate90();
//      robot.turnRight();
//      if(!visited.contains(current.forward(vec)) && robot.move()) {
//        backtrack(current, vec, robot, visited);
//        current.backward(vec);
//        for(int i = 0; i < 2; i++) robot.turnRight();
//        robot.move();
//        for(int i = 0; i < 2; i++) robot.turnRight();
//      }
//      vec.rotate270();
//      robot.turnLeft();
//
//      //180
//      vec.rotate180();
//      robot.turnRight();
//      robot.turnRight();
//      if(!visited.contains(current.forward(vec)) && robot.move()) {
//        backtrack(current, vec, robot, visited);
//        current.backward(vec);
//        for(int i = 0; i < 2; i++) robot.turnRight();
//        robot.move();
//        for(int i = 0; i < 2; i++) robot.turnRight();
//      }
//      vec.rotate180();
//      robot.turnRight();
//      robot.turnRight();
//
//
//
//      //270
//      vec.rotate270();
//      robot.turnLeft();
//      if(!visited.contains(current.forward(vec)) && robot.move()) {
//        backtrack(current, vec, robot, visited);
//        current.backward(vec);
//        for(int i = 0; i < 2; i++) robot.turnRight();
//        robot.move();
//        for(int i = 0; i < 2; i++) robot.turnRight();
//      }
//      vec.rotate90();
//      robot.turnRight();
//    }
//  }
//}
