/**
 * Created by nhan on 7/16/16.
 */
public class DecimalZip {
    public int solution(int A, int B){
        String lim = "" + 100000000;
        String a =  "" + A;
        String b = "" + B;

        char[] first = a.toCharArray();
        char[] sec = b.toCharArray();

        StringBuffer buffer = new StringBuffer();

        boolean fflag = true;
        int i = 0, j = 0;

        for(; i < first.length && j < sec.length; ){
            if(fflag) {
                buffer.append(first[i]);
                i++;
            }  else {
                buffer.append(sec[j]);
                j++;
            }

            fflag = fflag ? false : true;
        }

        if(i == first.length) {
            for(j = j; j < sec.length; j++) buffer.append(sec[j]);
        } else {
            for(i = i; i < first.length; i++) buffer.append(first[i]);
        }

        String str = buffer.toString();

        if(str.length() > lim.length()) return -1;

        return  Integer.parseInt(str);
    }

    public static void main(String[] args) {
        DecimalZip solver = new DecimalZip();
        int a = 12, b = 0;
        System.out.println(solver.solution(a,b));
    }
}
