package graph;
import java.util.*;

public class CourseSchedule {
    class Edge {
        int from, to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public boolean equals(Object other){
            Edge o = (Edge)other;

            return this.from == o.from && o.to == this.to;
        }

        public int hashCode() {
            return this.from * 10000000 + to;
        }
    }
    boolean cycle(Hashtable<Integer, List<Integer>> graph, int current, Set<Integer> visited, Set<Integer> rec) {
        if(rec.contains(current)) return false;
        if(visited.contains(current)) return true;

        visited.add(current);
        rec.add(current);
        List<Integer> next = graph.get(current);

        boolean result = true;

        if(next != null) {
            for(Integer i : next) {
                result &= cycle(graph, i, visited, rec);
            }
        }

        rec.remove(current);

        return result;
    }

    public boolean canFinish(int numCourses, int[][] arr) {
        if(arr == null || arr.length == 0) return true;
        Hashtable<Integer, List<Integer>> graph = new Hashtable<Integer, List<Integer>>();
        Set<Integer> v = new HashSet<Integer>();

        for(int i = 0; i < arr.length; i++) {
            v.add(arr[i][0]);
            v.add(arr[i][1]);

            if(graph.containsKey(arr[i][0])) {
                graph.get(arr[i][0]).add(arr[i][1]);
            } else {
                graph.put(arr[i][0], new ArrayList());
                graph.get(arr[i][0])
                        .add(arr[i][1]);
            }
        }

        System.out.println(graph);
        Set<Integer> covered = new HashSet<Integer>();

        for(Integer i : v) {
            if(!cycle(graph, i, new HashSet(), new HashSet())) return false;
        }

        return true;
    }
}
