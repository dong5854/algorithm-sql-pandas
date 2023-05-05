import java.util.*;

class Solution {
    
    Map<String, Integer> genrePlaySum = new HashMap<>();
    
    class Song implements Comparable<Song> {
        
        int num;
        String genre;
        int plays;
        
        public Song(int num, String genre, int plays) {
            this.num = num;
            this.genre = genre;
            this.plays = plays;
            genrePlaySum.put(genre, genrePlaySum.getOrDefault(genre, 0) + plays);
        }
        
        @Override
        public int compareTo(Song o) {
            int c = -Integer.compare(genrePlaySum.get(this.genre), genrePlaySum.get(o.genre));
            if (c == 0) c = -Integer.compare(this.plays, o.plays);
            if (c == 0) c = Integer.compare(this.num, o.num);
            return c;
        }
    }
    
    public List<Integer> solution(String[] genres, int[] plays) {
        Song[] songs = new Song[genres.length];
        for (int i = 0; i < genres.length; i++) {
            songs[i] = new Song(i, genres[i], plays[i]);
        }
        
        Arrays.sort(songs);
        Map<String, Integer> genreAddedCnt = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (Song song : songs) {
            int genreCnt = genreAddedCnt.getOrDefault(song.genre, 0);
            if (genreCnt >= 2) continue;
            ans.add(song.num);
            genreAddedCnt.put(song.genre, genreAddedCnt.getOrDefault(song.genre, 0) + 1);
        }
        
        return ans;
    }
}