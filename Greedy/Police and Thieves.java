class Solution 
{ 
    static int catchThieves(char arr[], int n, int k) 
	{ 
        List<Integer> police = new ArrayList<>();
        List<Integer> thieves = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else if (arr[i] == 'T') {
                thieves.add(i);
            }
        }
        
        int i = 0, j = 0, ans = 0;
        
        while (i < police.size() && j < thieves.size()) {
            if (Math.abs(police.get(i) - thieves.get(j)) <= k) {
                ans++;  
                i++;
                j++;
            } else if (police.get(i) < thieves.get(j)) {
                i++;  
            } else {
                j++;  
            }
        }
        
        return ans;
	} 
} 
