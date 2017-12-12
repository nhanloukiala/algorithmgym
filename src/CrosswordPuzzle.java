import java.util.*;

/**
 * Created by ntrinh on 29/11/17.
 * <p>
 * Link : https://www.hackerrank.com/challenges/crossword-puzzle/problem
 */

public class CrosswordPuzzle {
    private static void dim2Copy(char[][] matrix, char[][] dest) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dest[i][j] = matrix[i][j];
            }
        }
    }

    private static boolean scan(char matrix[][], LinkedList<Character> word, boolean hor) {
        // Scan horizontally
        if (hor) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length - word.size(); j++) {
                    if (matrix[i][j] == '-' || matrix[i][j] == word.getFirst()) {
                        if (tryPut(matrix, word, i, j, hor))
                            return true;
                    }
                }
            }
        } else {
            // Scan vertically
            for (int j = 0; j < matrix[0].length; j++) {
                for (int i = 0; i < matrix.length - word.size(); i++) {
                    if (matrix[i][j] == '-' || matrix[i][j] == word.getFirst()) {
                        if (tryPut(matrix, word, i, j, hor))
                            return true;
                    }
                }
            }
        }

        return false;
    }

    private static List<char[][]> scanMod(char matrix[][], LinkedList<Character> word, boolean hor) {
        List<char[][]> result = new ArrayList<char[][]>();

        // Scan horizontally
        if (hor) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j <= matrix[0].length - word.size(); j++) {
                    if (matrix[i][j] == '-' || word.getFirst() == (matrix[i][j])) {
                        char[][] cloneMat = new char[10][10];
                        dim2Copy(matrix, cloneMat);
                        if (tryPut(cloneMat, word, i, j, hor))
                            result.add(cloneMat);

                    }
                }
            }
        } else {
            // Scan vertically
            for (int j = 0; j < matrix[0].length; j++) {
                for (int i = 0; i <= matrix.length - word.size(); i++) {
                    if (matrix[i][j] == '-' || matrix[i][j] == word.getFirst()) {
                        char[][] cloneMat = new char[10][10];
                        dim2Copy(matrix, cloneMat);
                        if (tryPut(matrix, word, i, j, hor))
                            result.add(cloneMat);
                    }
                }
            }
        }

        return result;
    }

    private static boolean tryPut(char matrix[][], LinkedList<Character> word, int i, int j, boolean hor) {
        if (hor) {
            int current = j;
            for (Character c : word) {
                if (!(matrix[i][j] == c || matrix[i][j] == '-')) return false;
                else j++;
            }

            for (Character c : word) {
                matrix[i][current] = c;
                current++;
            }

            return true;
        } else {
            int current = i;
            for (Character c : word) {
                if (!(matrix[i][j] == c || matrix[i][j] == '-')) return false;
                else i++;
            }

            for (Character c : word) {
                matrix[current][j] = c;
                current++;
            }

            return true;
        }
    }


    private static void print(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(String.valueOf(matrix[i]));
        }
    }

    private static void solve(char[][] matrix, ArrayList<String> candidates) {
        if (candidates.isEmpty()) {
            print(matrix);
            return;
        }

        for (String word : candidates) {
            LinkedList<Character> lword = new LinkedList<>();
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                lword.add(arr[i]);
            }

            char[][] mat2 = new char[10][10];
            dim2Copy(matrix, mat2);

            List<char[][]> result_hor = scanMod(mat2, lword, true);

            if (!result_hor.isEmpty()) {
                ArrayList<String> newCand = ((ArrayList<String>) candidates.clone());
                newCand.remove(word);
                for (char[][] mat2Pos : result_hor) {
                    solve(mat2Pos, newCand);
                }

            }

            char[][] mat22 = new char[10][10];
            dim2Copy(matrix, mat22);

            List<char[][]> result_ver = scanMod(mat22, lword, false);

            if (!result_ver.isEmpty()) {
                ArrayList<String> newCand = ((ArrayList<String>) candidates.clone());
                newCand.remove(word);

                for (char[][] mat2Pos : result_ver) {
                    solve(mat2Pos, newCand);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[][] matrix = new char[10][10];

        for (int i = 0; i < 10; i++) {
            String line = in.nextLine();
            char[] arr = line.toCharArray();
            for (int j = 0; j < arr.length; j++) {
                matrix[i][j] = arr[j];
            }
        }

        String input = in.next();
        String[] candidates = input.split(";");

        ArrayList<String> c = new ArrayList<>();

        for (int i = 0; i < candidates.length; i++) {
            c.add(candidates[i]);
        }

        solve(matrix, c);
    }
}
