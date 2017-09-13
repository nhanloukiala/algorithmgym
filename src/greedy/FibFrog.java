package greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by nhan on 7/15/16.
 */
public class FibFrog {
    public int solution(int[] arr){
        int start = -1;
        ArrayList<Integer> dist = new ArrayList<Integer>();
        Stack<Integer> answer = new Stack<Integer>();

        ArrayList<Integer> fib = genFib(arr.length);

        for(int i = 0; i < arr.length ; i++) {
            if (arr[i] == 1) {
                dist.add(i - start);
                start = i;
            }
        }
        dist.add(arr.length - start);

        int temp = 0;
        for(int i = 0 ; i < dist.size(); i++) {
            temp += dist.get(i);
            if(find(temp, fib)){
                if(answer.size() > 0 && find(temp + answer.peek(), fib)) {
                    temp += answer.pop();
                }

                answer.push(temp);
                temp = 0;
            }
        }

        if(temp == 0) {
            return answer.size();
        } else {
            return -1;
        }

    }

    public boolean find(int i, ArrayList<Integer> arr){
        int lo = 0;
        int hi = arr.size() - 1;
        int mid = (lo + hi) / 2;

        while(lo < hi) {
            if(arr.get(mid) == i)  {
                return true;
            } else if (arr.get(mid) > i){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }

            mid = (lo + hi) / 2;
        }

        return false;
    }

    public ArrayList<Integer> genFib(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        arr.add(1);

        for(int i = 2;  arr.get(i - 1) + arr.get(i - 2) < n + 3; i++) {
            arr.add(arr.get(i - 1) + arr.get(i - 2));
        }

        return arr;
    }

    public static void main(String[] args) {
        FibFrog solver = new FibFrog();
//        int arr[] = new int[]{0,0,0,1,1,0,1,0,0,0,0};
        int arr[] = new int[]{1};
        System.out.println(solver.solution(arr));
    }
}
