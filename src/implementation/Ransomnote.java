package implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by nhan on 10/16/17.
 */
public class Ransomnote {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();

        in.nextLine();

        String mstr = in.nextLine();
        String nStr = in.nextLine();

        Map<String, Integer> dict = new HashMap<String, Integer>();

        for(String str: mstr.split(" ")) {
            int value = dict.getOrDefault(str, 0);
            dict.put(str, ++value);
        }

        for(String str: nStr.split(" ")){
            int value = dict.getOrDefault(str, 0);

            if(value > 0) {
                dict.put(str, --value);
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("YES");
    }
}
