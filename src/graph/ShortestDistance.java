package graph;

import java.util.*;

class ShortestDistance {
  static public int shortestDistance(int[][] grid) {
    Set<ArrayList<Integer>> obs = new HashSet<ArrayList<Integer>>();
    Set<ArrayList<Integer>> houses = new HashSet<ArrayList<Integer>>();
    int[][] reach = new int[grid.length][grid[0].length];

    for(int i = 0 ; i < grid.length; i++) {
      for(int j = 0; j < grid[0].length; j++) {
        if(grid[i][j] == 1) {
          houses.add(list(i,j));
        }
        if(grid[i][j] == 2) obs.add(list(i,j));
      }
    }

    int[][] dist = new int[grid.length][grid[0].length];

    for(List<Integer> h : houses) {
      boolean r = bfs(dist, reach, h.get(0), h.get(1), obs, houses);
      if(!r) return -1;
    }


    int min = Integer.MAX_VALUE;

    System.out.println(Arrays.deepToString(reach));

    for(int i = 0 ; i < grid.length; i++) {
      for(int j = 0; j < grid[0].length; j++) {
        if(reach[i][j] == houses.size())
          min = min < dist[i][j] ? min : dist[i][j];
      }
    }

    return min == Integer.MAX_VALUE ? - 1: min;
  }

  static boolean bfs(int[][] dist, int[][] reach, int i1, int j1, Set<ArrayList<Integer>> obs, Set<ArrayList<Integer>> house) {
    Queue<ArrayList<Integer>> queue = new LinkedList();
    Set<ArrayList<Integer>> visited = new HashSet<ArrayList<Integer>>();
    int depth = -1;
    queue.add(list(i1, j1));
    visited.add(list(i1, j1));
    int[][] dim = {{1,0}, {0,1}, {0,-1}, {-1, 0}};
    Set<ArrayList<Integer>> connected = new HashSet<ArrayList<Integer>>();
    connected.add(list(i1, j1));

    while(!queue.isEmpty()) {
      Queue<ArrayList<Integer>> layer = new LinkedList();
      while(!queue.isEmpty()) layer.add(queue.remove());
      depth++;

      for(ArrayList<Integer> current : layer) {
        if(!house.contains(current)) reach[current.get(0)][current.get(1)]++;
        dist[current.get(0)][current.get(1)] += depth;
        System.out.println(Arrays.deepToString(dist));

        for(int[] arr : dim) {
          int i = current.get(0) + arr[0];
          int j = current.get(1) + arr[1];
          ArrayList<Integer> location = list(i,j);
          if(house.contains(location)) connected.add(location);

          if(i >= 0
              && j >= 0
              && i < dist.length
              && j < dist[0].length
              && !visited.contains(location)
              && !obs.contains(location)
              && !house.contains(location)) {
            visited.add(location);
            queue.add(location);
          }
        }
      }
    }

    return connected.equals(house);
  }

  static ArrayList<Integer> list(int i, int j) {
    ArrayList<Integer> list = new ArrayList();
    list.add(i);
    list.add(j);

    return list;
  }

  public static void main(String[] args) {
    int[][] grid = {{1,0,2,0,1}, {0,0,0,0,0}, {0,0,1,0,0}};

    System.out.println(shortestDistance(grid));
  }
}
