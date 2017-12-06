package amazon;

import java.util.HashMap;
import java.util.Map;

public class FirstProblem {
    public static String solution(String S) {
        // write your code in Java SE 8
        String[] lines = S.split("\n");
        Map<String, Long> map = new HashMap<>();

        map.put("music", 0L);
        map.put("movies", 0L);
        map.put("images", 0L);
        map.put("other", 0L);
        String[] music =  {"mp3", "aac", "flac"};
        String[] images =  {"jpg", "bmp", "gif"};
        String[] movies =  {"mp4", "avi", "mkv"};
        String[] other =  {};

        if(!S.isEmpty()){
            for(String line : lines){
                if(categorize(map, line, "music", music)) continue;
                else if (categorize(map, line, "images", images)) continue;
                else if (categorize(map, line, "movies", movies)) continue;
                else categorize(map, line, "other", other);
            }
        }

        StringBuffer result = new StringBuffer();
        result.append(String.format("music %sb\n", map.get("music").toString()));
        result.append(String.format("images %sb\n", map.get("images").toString()));
        result.append(String.format("movies %sb\n", map.get("movies").toString()));
        result.append(String.format("other %sb", map.get("other").toString()));

        return result.toString();
    }

    private static boolean categorize(Map<String, Long> map, String line, String category, String[] extensions) {
        String[] parts = line.split(" ");

        int value = Integer.parseInt(parts[1].split("b")[0]);

        if(category.equals("other")) {
            long current = map.get(category);
            current += value;
            map.put(category, current);
            return true;
        }

        for(String extension: extensions){
            if(parts[0].endsWith(extension)) {
                long current = map.get(category);
                current += value;
                map.put(category, current);
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        String input = "my.song.mp3 11b\n" +
                "greatSong.flac 1000b\n" +
                "not3.txt 5b\n" +
                "video.mp4 200b\n" +
                "game.exe 100b\n" +
                "mov!e.mkv 10000b";

        String result = "music 1011b\n" +
                "images 0b\n" +
                "movies 10200b\n" +
                "other 105b";

        System.out.println(solution(input).equals(result));

    }
}
