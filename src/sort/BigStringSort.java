package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ntrinh on 14/09/17.
 */
public class BigStringSort {
    class StringWrapper {
        private String str;
        public StringWrapper(String str) {
            this.str = str;
        }
    }

    private int[] solve(String[] arr){
        StringWrapper[] result = new StringWrapper[arr.length];

        for(int i = 0; i < arr.length; i++) {
            result[i] = this.new StringWrapper(arr[i]);
        }

        Arrays.sort(result, new Comparator<StringWrapper>() {
            @Override
            public int compare(StringWrapper o1, StringWrapper o2) {
                if(o1.str.equals(o2.str))
                    return 0;
                else if(o1.str.length() > o2.str.length())
                    return 1;
                else if(o1.str.length() < o2.str.length())
                    return -1;
                else
                    return o1.str.compareTo(o2.str);
            }
        });

        return null;
    }

    public static void main(String[] args) {

    }
}
