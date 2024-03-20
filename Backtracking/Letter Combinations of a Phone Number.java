class Solution {
    public static String[] keypad = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        printComb(digits, 0, "", result);
        return result;
    }

    public static void printComb(String digits, int idx, String combination, List<String> result) {
        if (idx == digits.length()) {
            result.add(combination);
            return;
        }
        char currChar = digits.charAt(idx);
        String mapping = keypad[currChar - '0'];

        for (int i = 0; i < mapping.length(); i++) {
            printComb(digits, idx + 1, combination + mapping.charAt(i), result);
        }
    }
}
