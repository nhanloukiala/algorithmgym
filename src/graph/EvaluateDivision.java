package graph;
import java.util.*;

public class EvaluateDivision {

  static class Solution {

    class Node {
      String val;
      Set<Edge> edges;

      public Node(String val, String to, double weight) {
        this.val = val;
        this.edges = new HashSet<Edge>();
        this.edges.add(new Edge(val, to, weight));
      }

      public void addEdge(String to, double weight){
        this.edges.add(new Edge(val, to, weight));
      }
    }

    class Edge{
      String from;
      String to;
      double val;

      public Edge(String from, String to, double val) {
        this.from = from;
        this.to = to;
        this.val = val;
      }

      public int hashCode(){
        return from.hashCode() * 10 + to.hashCode();
      }

      public boolean equals(Object other){
        return ((Edge)other).from.equals(this.from) &&
            ((Edge)other).to.equals(this.to);
      }
    }

    Hashtable<String, Node> graph = new Hashtable();

    private void populateGraph(String[][] equations, double[] values) {
      if(equations == null || equations.length == 0)
        return;

      for(int i = 0; i < equations.length; i++) {
        addNode(equations[i][0], equations[i][1], values[i]);
        addNode(equations[i][1], equations[i][0], 1 / values[i]);
      }

      return;
    }

    private void addNode(String from, String to, double weight) {
      if(graph.containsKey(from)){
        graph.get(from).addEdge(to, weight);
      } else {
        graph.put(from, new Node(from, to, weight));
      }
    }

    private double calcPath(String a, String b) {
      if(!graph.containsKey(a) || !graph.containsKey(b)) return -1;
      if(a.equals(b)) return 1;

      HashSet<String> visited = new HashSet();
      Stack<Node> stack = new Stack();
      Hashtable<String, Edge> trace = new Hashtable<String, Edge>();

      stack.push(graph.get(a));

      while(!stack.isEmpty()) {
        Node current = stack.pop();
        visited.add(current.val);

        if(current.val == b)
          break;
        for(Edge edge : current.edges) {
          if(!visited.contains(edge.to)) {
            trace.put(edge.to, edge);
            stack.push(graph.get(edge.to));
          }
        }
      }

      if(!trace.containsKey(b)) return -1.0;

      String currentTrace = b;
      double result = 1.0;
      while(!currentTrace.equals(a)){
        result *= trace.get(currentTrace).val;
        currentTrace = trace.get(currentTrace).from;
      }

      return result;
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
      double[] result = new double[queries.length];
      populateGraph(equations, values);

      for(int i = 0; i < queries.length; i++) {
        result[i] = calcPath(queries[i][0], queries[i][1]);
      }

      return result;
    }
  }

  public static void main(String[] args) {
    String[][] eq = new String[][]{{"a","b"},{"b","c"} , {"bc", "cd"}};
    double[] vals = new double[]{1.5, 2.5, 5.0};
    String[][] qs = new String[][] { {"cd", "bc"} };

    double[] result = (new Solution()).calcEquation(eq, vals, qs);
    System.out.println(result);
  }
}
