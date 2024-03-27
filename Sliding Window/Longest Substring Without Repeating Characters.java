class Solution {
    public int lengthOfLongestSubstring(String s) {
        int windowStart =0 ;
        int windowEnd =0 ;
        int n =s.length();

        //HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        while(windowEnd <n ){
            char ch = s.charAt(windowEnd);
            // if (set.contains(ch)){
                if(map.containsKey(ch) && map.get(ch)>= windowStart){
                //shrinking
                //while(windowStart<windowEnd && set.contains(ch)){
                    //set.remove(s.charAt(windowStart));
                    //windowStart++;
                    //}
                    windowStart = map.get(ch)+1;
                }
                map.put(ch,windowEnd);
                maxLen = Math.max(maxLen, windowEnd - windowStart +1);
                windowEnd++; 
        }
        return (maxLen == Integer.MIN_VALUE)?0:maxLen;
    }
}
