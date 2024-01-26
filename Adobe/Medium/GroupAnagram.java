class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null|| strs.length==0){
            return new ArrayList<>();
        }
        Map<String ,List<String>> frequencyStringMap =new HashMap<>();
        for(String str : strs){
            String frequencyString = getFrequencyString(str);
        
        //if the frequency string is pressent ,add the string to the list
            if(frequencyStringMap.containsKey(frequencyString)){
                frequencyStringMap.get(frequencyString).add(str);
            }
            else{
            //else create a new list
                List<String> strList =new ArrayList<>();
                strList.add(str);
                frequencyStringMap.put(frequencyString ,strList);
            }
        }
        return new ArrayList<>(frequencyStringMap.values());
    }
    
    private String getFrequencyString(String str){
        //Frequency buckets
        int[] freq =new int[26];

        //iterate over each character
        for(char c: str.toCharArray()){
            freq[c-'a']++;
        }

        //start craeting the frequency string 
        StringBuilder frequencyString =new StringBuilder("");
        char c= 'a';
        for(int i : freq){
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
        }
        return frequencyString.toString();
    }
}
