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
    
  boolean noCycle(int node, int from, int to, Hashtable<Integer, List<Integer>> graph, Set<Integer> vertexes) {
      graph.get(from).remove((Integer)to);
      System.out.println(graph);
      Set<Integer> visited = new HashSet<Integer>();
      Stack<Integer> stack = new Stack<Integer>();
      Stack<Integer> parents = new Stack<Integer>();
      stack.add(node);
      parents.add(node);
      
      while(!stack.isEmpty()) {
          int current = stack.pop();
          int parent = parents.pop();
          System.out.println(stack);
          
          if(visited.contains(current)) {
              graph.get(from).add(to);
              return false;
          } else {
              visited.add(current);
              if(graph.get(current) != null) {
              for(Integer i : graph.get(current)) {
                  parents.add(current);
                  stack.push(i);
              }
            }
          }
      }
      
      graph.get(from).add(to);
      System.out.println(visited);
      
      if(vertexes.size() == visited.size())
        return true;
      else 
          return false;
  }

  public int[] findRedundantDirectedConnection(int[][] arr) {
    Hashtable<Integer, List<Integer>> graph = new Hashtable<Integer, List<Integer>>();
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
      if(set.contains(arr[i][1]) && noCycle(arr[node][0], arr[i][0], arr[i][1], graph, vertex)) {
          return new int[]{ arr[i][0], arr[i][1]}; 
      }
    }

    return null;
  }
}
