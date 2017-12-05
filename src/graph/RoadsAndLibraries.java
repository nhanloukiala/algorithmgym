package graph;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by nhan on 11/10/17.
 */
public class RoadsAndLibraries {
    private static class Node {
        int name;
        Set<Node> next;

        public Node(int name) {
            this.name = name;
            this.next = new HashSet<>();
        }

        public void addNode(Node node) {
            next.add(node);
        }

        @Override
        public int hashCode() {
            return this.name % Integer.MAX_VALUE;
        }

        @Override
        public boolean equals(Object obj) {
            return this.name == ((Node) obj).name;
        }
    }

    private static long findSubgraph(Map<Integer, Node> nodes, int cr, int cl) {
        List<Integer> subgraphs = new ArrayList<>();
        int count = 0;

        for (Integer node : nodes.keySet()) {
            if (nodes.containsKey(node)) {
                Set<Node> visited = new HashSet<>();
                subgraphs.add(dfs(nodes.get(node), visited));
                for (Node n : visited) {
                    nodes.remove(n.name);
                }
            }
        }

        long result = 0;
        if (cl <= cr) {
            for (Integer in : subgraphs) {
                result += cl * in;
            }
        } else {
            for (Integer in : subgraphs) {
                result += cl + cr * (in - 1);
            }
        }

        return result;
    }

    private static int dfs(Node current, Set<Node> visited) {
        if (current.next.isEmpty()) {
            visited.add(current);
            return 1;
        }

        int count = 1;
        visited.add(current);

        for (Node node : current.next) {
            if (!visited.contains(node)) {
                count += dfs(node, visited);
            }
        }


        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int q = in.nextInt();

        Map<Integer, Node> nodes = new ConcurrentHashMap<>();

        for (int i = 0; i < q; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int cl = in.nextInt();
            int cr = in.nextInt();

            for (int j = 0; j < m; j++) {
                int left = in.nextInt();
                int right = in.nextInt();

                Node lNode = nodes.getOrDefault(left, new Node(left));
                nodes.putIfAbsent(left, lNode);

                Node rNode = nodes.getOrDefault(right, new Node(right));
                nodes.putIfAbsent(right, rNode);

                lNode.addNode(rNode);
                rNode.addNode(lNode);
            }

            for (int k = 1; k < n + 1; k++) {
                nodes.putIfAbsent(k, new Node(k));
            }


            System.out.println(findSubgraph(nodes, cr, cl));
        }
    }
}
