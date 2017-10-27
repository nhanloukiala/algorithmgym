package search;

import java.util.*;

/**
 * Created by ntrinh on 26/10/17.
 */
public class ConnectedCell {
    static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public int hashCode() {
            return row * 10  + col;
        }

        @Override
        public boolean equals(Object obj) {
            Pair other = (Pair) obj;
            return other.row == this.row && other.col == this.col;
        }
    }

    private static int BFS(boolean[][] arr, int row, int col) {
        int area = 0;
        arr[row][col] = false;
        Queue<Pair>  queue = new LinkedList<>();
        Set<Pair> visited = new HashSet<Pair>();

        queue.add(new Pair(row, col));
        visited.add(new Pair(row, col));

        while(!queue.isEmpty()) {
            List<Pair> current = new ArrayList<>();

            while(!queue.isEmpty()) current.add(queue.poll());

            for(Pair p : current) {
                area += 1;

                tryPlace(p.row + 1, p.col, arr, visited, queue);
                tryPlace(p.row, p.col + 1, arr, visited, queue);
                tryPlace(p.row -1, p.col , arr, visited, queue);
                tryPlace(p.row, p.col - 1, arr, visited, queue);
            }
        }

        return area;
    }

    private static void tryPlace(int x, int y, boolean[][] arr, Set<Pair> visited, Queue<Pair> queue) {
        if(move(x, y, arr, visited)) {
            Pair pair = new Pair(x, y);
            queue.add(pair);
            visited.add(pair);
            arr[x][y] = false;
        }
    }

    private static boolean move(int x, int y, boolean arr[][], Set<Pair> visited) {
        return x >= 0 && y >= 0 && x < arr.length && y < arr[0].length && arr[x][y] && !visited.contains(new Pair(x, y));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        boolean[][] arr = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cell = in.nextInt();

                if(cell == 1) arr[i][j] = true;
                else arr[i][j] = false;
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j])
                    max = Math.max(BFS(arr, i, j), max);
            }
        }

        System.out.println(max);
    }
}
