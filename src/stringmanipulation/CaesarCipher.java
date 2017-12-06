package stringmanipulation;

import java.util.Scanner;

/**
 * Created by nhan on 10/19/17.
 */
public class CaesarCipher {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String str = in.nextLine();
        int l = in.nextInt();

        char[] arr = str.toCharArray();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 'A' && arr[i] <= 'Z')
                arr[i] = (char)(Character.getNumericValue('A') + ((Character.getNumericValue(arr[i]) - l + 26) % 26));

            if(arr[i] >= 'a' && arr[i] <= 'z')
                arr[i] = (char)(Character.getNumericValue('A') + ((Character.getNumericValue(arr[i]) - l + 26) % 26));
        }

        System.out.println(String.valueOf(arr));
    }
}
