class Solution {
    public List<String>  getNeighbour(String word,HashSet<String> set){
        List<String> neighbours = new ArrayList<>();
        for(int i =0 ;i<word.length(); i++){
            for(char ch ='a'; ch<='z' ;ch++){
                if(ch == word.charAt(i)){
                    continue;
                }
                String newWord = word.substring(0,i) + ch +word.substring(i+1, word.length());
                if(set.contains(newWord)){
                    neighbours.add(newWord);
                }
            }
        }
        return neighbours;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String > set  = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        Queue<String> queue= new LinkedList<>();
        queue.offer(beginWord);
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        int level = 0 ;
        while(!queue.isEmpty()){
            int currLevelSize = queue.size();
            //level wise
            for(int i =0 ;i < currLevelSize;i++){
                String node= queue.poll();
                if(node.equals(endWord)){
                    return level+1;
                }
                //adjLsit
                List<String> neighbour = getNeighbour(node, set);
                for(String word : neighbour){
                    if(set.contains(word)){
                        queue.offer(word);
                        set.remove(word);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
