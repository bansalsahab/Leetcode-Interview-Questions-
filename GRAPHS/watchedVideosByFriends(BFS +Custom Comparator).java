class Solution {
    class Pair implements Comparable<Pair>{
        String video;
        int frq;
        Pair(String video, int frq){
            this.video = video;
            this.frq = frq;
        }
        public int compareTo(Pair that){
            if(this.frq == that.frq){
                return this.video.compareTo(that.video);
            }
            return this.frq -that.frq;
        }
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited= new HashSet<>();
        int currLevel =0;
        queue.offer(id);
        visited.add(id);

        while(!queue.isEmpty()){
            int size = queue.size();
            //iterate level by level
            for(int i = 0 ;i <size;i++){
                int currId = queue.poll();
                for(int friend :friends[currId]){
                    if(!visited.contains(friend)){
                        visited.add(friend);
                        queue.offer(friend);
                    }
                }
            }
            currLevel++;
            if(currLevel == level){
                break;
            }
        }
        HashMap<String , Integer> map = new HashMap<>();
        while(!queue.isEmpty()){
            int curId = queue.poll();
            for(String video : watchedVideos.get(curId)){
                map.put(video, map.getOrDefault(video , 0) +1);
            }
        }
        List<Pair> videoList = new ArrayList<>();
        for(String video : map.keySet()){
            videoList.add(new Pair(video ,map.get(video)));
        }
        Collections.sort(videoList);
        List<String> res=  new ArrayList<>();
        for(Pair pair :videoList ){
            res.add(pair.video);
        }
        return res;
         
    }
}
