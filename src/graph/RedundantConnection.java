package graph;

import java.util.*;

class RedundantConnection {
  public Set<Integer> findRemovableEdge(int v, Map<Integer, List<Integer>> graph, Set<Integer> vertex) {
    //start from node, remove edge if find cycle
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> result = new HashSet<>();

    queue.add(v);
    boolean removedEdge = true;

    while(!queue.isEmpty()) {
      int current = queue.poll();
      if(visited.contains(current)) {
        if(!removedEdge)
          return new HashSet<>();
        else {
          removedEdge = false;
          result.add(current);
        }
      } else {
        visited.add(current);
        List<Integer> currentDest = graph.get(current);
        if(currentDest != null) {
          queue.addAll(currentDest);
        }
      }
    }

    if(vertex.size() == visited.size())
      return result;
    else
      return new HashSet<>();
  }

  public int[] findRedundantDirectedConnection(int[][] arr) {
    // iterate through edges, pick the start vertex and do a dfs, if you encounter circle, remove the edge for the first time, if the dfs finishes, it's an edge which can be removed.

    Map<Integer, List<Integer>> graph = new Hashtable<Integer, List<Integer>>();
    HashSet<Integer> vertex = new HashSet<Integer>();

    // populate
    for(int i = 0; i < arr.length; i++) {
      vertex.add(arr[i][0]);
      vertex.add(arr[i][1]);
      if(graph.containsKey(arr[i][0])) {
        graph.get(arr[i][0]).add(arr[i][1]);
      } else {
        List<Integer> edges = new ArrayList<Integer>();
        edges.add(arr[i][1]);
        graph.put(arr[i][0], edges);
      }
    }

    Set<Integer> set = new HashSet<Integer>();

    int node = 0;
    for(int i = 0; i < arr.length; i++) {
      set = findRemovableEdge(arr[i][0], graph, vertex);
      node = i;
      if(!set.isEmpty()) break;
    }

    for(int i = arr.length - 1; i >= 0; i--) {
      if(set.contains(arr[i][1])) return new int[] {arr[i][0], arr[i][1] };
    }

    return null;
  }
}
