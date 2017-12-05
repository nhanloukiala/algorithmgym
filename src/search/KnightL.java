package search;

import java.util.*;

/**
 * Created by ntrinh on 26/10/17.
 */
public class KnightL {
    private static class Knight {
        private int x;
        private int y;
        private int posx;
        private int posy;

        public Knight(int x, int y, int posx, int posy) {
            this.x = x;
            this.y = y;
            this.posx = posx;
            this.posy = posy;
        }

        public static boolean possible(int x, int y) {
            return (x >= 0 && y >= 0 && x <= size - 1 && y <= size - 1);
        }

        public List<Knight> move() {
            List<Knight> moves = new ArrayList<>(8);
            tryPlace(this.posx - this.x, this.posy - this.y, moves, this);
            tryPlace(this.posx - this.x, this.posy + this.y, moves, this);
            tryPlace(this.posx + this.x, this.posy - this.y, moves, this);
            tryPlace(this.posx + this.x, this.posy + this.y, moves, this);
            tryPlace(this.posx - this.y, this.posy - this.x, moves, this);
            tryPlace(this.posx - this.y, this.posy + this.x, moves, this);
            tryPlace(this.posx + this.y, this.posy - this.x, moves, this);
            tryPlace(this.posx + this.y, this.posy + this.x, moves, this);

            return moves;
        }

        private void tryPlace(int posx, int posy, List<Knight> moves, Knight parent) {
            if(possible(posx, posy))
                moves.add(new Knight(parent.x, parent.y, posx, posy));
        }

        @Override
        public boolean equals(Object obj) {
            return this.posx == ((Knight)obj).posx && this.posy == ((Knight) obj).posy;
        }

        @Override
        public int hashCode() {
            return this.posx * size + this.posy;
        }
    }

    private static int size;

    private static void solve(int n){
        size = n;
        for(int i  = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                    solve(i, j, n);

            }
            System.out.println();
        }
    }

    private static void solve(int i, int j, int n) {
        Knight origin = new Knight(i, j, 0, 0);
        Knight end = new Knight(i, j, n - 1, n - 1);

        Set<Knight> visited = new HashSet<Knight>();
        Queue<Knight> queue = new LinkedList<>();

        visited.add(origin);
        queue.add(origin);

        int depth = 0;
        while(!queue.isEmpty()) {
            if(visited.contains(end))
            {
                System.out.print(depth + " ");
                return;
            }
            depth++;
            List<Knight> list = new ArrayList<>();
            while(!queue.isEmpty())
                list.add(queue.poll());

            for(Knight k : list) {
                List<Knight> moves = k.move();
                for(Knight k1 : moves) {
                    if(k1.equals(end))
                    {
                        System.out.print(depth + " ");
                        return;
                    }
                    if(!visited.contains(k1)) {
                        queue.add(k1);
                        visited.add(k1);
                    }
                }
            }
        }

        System.out.print(-1 + " ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        solve(n);
    }
}
