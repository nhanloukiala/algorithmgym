import java.util.*;

/**
 * Created by nhan on 6/25/16.
 */
public class IntervalCubing311D {
    private static final int prime = 95542721;

    public int[] readRow(String row) {
        String[] str = row.split(" ");
        int[] values = new int[3];
        for (int i = 0; i < 3; i++) {
            values[0] = Integer.parseInt(str[0]);
            values[1] = Integer.parseInt(str[1]);
            values[2] = Integer.parseInt(str[2]);
        }

        return values;
    }

    private int[] generate(String n) {
        int[] arr = new int[50];
        int number = Integer.parseInt(n);
        int compare = number;
        long value = number;
        arr[0] = number;
        int count = 0;

        while (true) {
            count ++;
            value = ((value * value % prime) * value) % prime;
            arr[count] = (int) value;
            if (value == compare || value == 0) {
                break;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        IntervalCubing311D intervalcubing311D = new IntervalCubing311D();
        Scanner in = new Scanner(System.in);

        int numInt = Integer.parseInt(in.nextLine());
        String[] values = in.nextLine().split(" ");

        int[] number = new int[numInt];
        for (int i = 0; i < numInt; i++) {
            number[i] = Integer.parseInt(values[i]);
        }

        int[][] arr = new int[numInt][48];
        for (int i = 1; i < numInt; i++) {
            if(arr[i][0] == 0){
                int[] temp = intervalcubing311D.generate(values[i]);
                arr[i] = temp;
            }
        }

        int[] indices = new int[numInt];
        for (int i = 0; i < numInt; i++) {
            indices[i] = 1;
        }

        int num = Integer.parseInt(in.nextLine());
        ArrayList<Integer> results = new ArrayList<Integer>();
        for (int i = 0; i < num; i++) {
            int[] rgs = intervalcubing311D.readRow(in.nextLine());

            if (rgs[0] == 2) {
                for (int j = rgs[1] - 1; j < rgs[2]; j++) {
                    indices[j] = indices[j] + 1;
                }
            } else {
                int sum = 0;
                for (int j = rgs[1] - 1; j < rgs[2]; j++) {
                    int[] temp = arr[j];
                    int ind = (indices[j] - 1) % temp.length;
                    sum += temp[ind];
                }

                sum = sum % prime;
                System.out.println(sum);
            }
        }
//
//        for(int i = 0; i < results.size(); i++) {
//            System.out.println(results.get(i));
//        }
    }
}