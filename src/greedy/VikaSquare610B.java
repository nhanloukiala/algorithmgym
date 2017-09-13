package greedy;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by nhan on 6/29/16.
 */
public class VikaSquare610B implements Runnable {
    private void solve() {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String[] values = in.nextLine().split(" ");
        long arr[] = new long[n];

        long min = Long.MAX_VALUE;
        long firstMinIndex = -1;
        long lastMinIndex = Long.MAX_VALUE;
        long furthestDistance = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(values[i]);
            if (arr[i] < min) {
                min = arr[i];
                firstMinIndex = i;
            }

            if (arr[i] == min) {
                if(furthestDistance > i - lastMinIndex) {
                    furthestDistance = i - lastMinIndex;
                };

                lastMinIndex = i;
            }
        }

        furthestDistance = (furthestDistance > (n - (lastMinIndex - firstMinIndex + 1))) ? furthestDistance : (n - (lastMinIndex - firstMinIndex + 1));

        out.println(n * (min + 1) - (lastMinIndex - firstMinIndex + 1));
    }

    @Override
    public void run() {
        solve();
        out.close();
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new Thread(null, new VikaSquare610B(), "SegmentTreeSolver", 1 << 28).start();
    }
}

