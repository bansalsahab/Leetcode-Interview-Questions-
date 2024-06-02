class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int windowStart = 0;
        int windowEnd = 0;

        int s1Freq[] = new int[26];
        int s2Freq[] = new int[26];

        if (s1.length() > s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
        }

        while (windowEnd < s1.length()) {
            s2Freq[s2.charAt(windowEnd) - 'a']++;
            windowEnd++;
            
        }
        if (areArraysEqual(s1Freq, s2Freq)) {
            return true;
        }
        while (windowEnd < s2.length()) {
            s2Freq[s2.charAt(windowEnd) - 'a']++;  // Include the next character in the window
            s2Freq[s2.charAt(windowStart) - 'a']--;  // Exclude the character left out of the window
            
            // Check if the current window is a permutation of s1
            if (areArraysEqual(s1Freq, s2Freq)) {
                return true;
            }
            
            windowStart++;
            windowEnd++;
        }
        
        return false;

    }
    private boolean areArraysEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
