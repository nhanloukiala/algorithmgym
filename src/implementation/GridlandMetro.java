package implementation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * Created by nhan on 10/5/17.
 */
public class GridlandMetro {
    static private class TrainTrack {
        private int row;
        private int scol;
        private int ecol;

        public TrainTrack(int row, int scol, int ecol) {
            TrainTrack.this.row = row;
            TrainTrack.this.scol = scol;
            TrainTrack.this.ecol = ecol;
        }

//        public boolean equals(TrainTrack other){
//            if(other.row != TrainTrack.this.row) return false;
//            if((other.scol <= TrainTrack.this.scol && other.ecol >= TrainTrack.this.scol) || (TrainTrack.this.scol <= other.scol && TrainTrack.this.ecol >= other.scol)) return true;
//            return false; //never happens
//        }

        @Override
        public boolean equals(Object obj) {
            TrainTrack other = (TrainTrack)obj;
            if(other.row != TrainTrack.this.row) return false;
            if((other.scol <= TrainTrack.this.scol && other.ecol >= TrainTrack.this.scol) || (TrainTrack.this.scol <= other.scol && TrainTrack.this.ecol >= other.scol)) return true;
            return false; //never happens
        }

        public int hashCode() {
            return TrainTrack.this.row;
        }

        public TrainTrack combine(TrainTrack other) {
            if(!TrainTrack.this.equals(other)) return null;

            return new TrainTrack(TrainTrack.this.row, Math.min(TrainTrack.this.scol, other.scol), Math.max(TrainTrack.this.ecol, other.ecol));
        }

        public int coveredUnits() {
            return TrainTrack.this.ecol - TrainTrack.this.scol + 1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        long m = in.nextInt();
        int k = in.nextInt();

        Map<TrainTrack, TrainTrack> hashMap = new HashMap<TrainTrack,TrainTrack>();

        for(int i = 0; i < k; i++) {
            int row = in.nextInt();
            int scol = in.nextInt();
            int ecol = in.nextInt();
            TrainTrack track = new TrainTrack(row, scol, ecol);
            if(!hashMap.containsKey(track)) hashMap.put(track, track);
            else {
                TrainTrack otherTrack = hashMap.get(track);
                TrainTrack newTrack = track.combine(otherTrack);
                hashMap.remove(track);
                hashMap.put(newTrack, newTrack);
            }
        }

        long sum = 0L;
        for(Map.Entry<TrainTrack, TrainTrack> kv : hashMap.entrySet()){
            sum += kv.getKey().coveredUnits();
        }

        System.out.println(m*n - sum);

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
