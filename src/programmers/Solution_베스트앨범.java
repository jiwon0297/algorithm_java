package programmers;

import java.util.*;
class Solution {
    static class Music implements Comparable<Music> {
        public int num;
        public String genre;
        public int play;
        
        public Music(int num, String genre, int play){
            this.num=num;
            this.genre=genre;
            this.play=play;
        }
        
        @Override
        public int compareTo(Music o2) {
            return o2.play-this.play;
        }

    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        //장르
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>(){
           @Override
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        
        ArrayList<String> gList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entryList){
            gList.add(entry.getKey());
        }
        
        //장르 내 노래
        ArrayList<Music> result = new ArrayList<>();
        for(String g : gList){
            ArrayList<Music> list = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals(g)){
                    list.add(new Music(i, g, plays[i]));
                }
            }
            Collections.sort(list);
            result.add(list.get(0));
            if(list.size()!=1){
                result.add(list.get(1));
            }
        }
        
        //print
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i]=result.get(i).num;
        }
        return answer;
    }
}