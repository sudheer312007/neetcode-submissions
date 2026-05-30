class Solution {
public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }

        Map<Integer, char[]> dict = new HashMap<>();

        dict.put(2, "abc".toCharArray());
        dict.put(3, "def".toCharArray());
        dict.put(4, "ghi".toCharArray());
        dict.put(5, "jkl".toCharArray());
        dict.put(6, "mno".toCharArray());
        dict.put(7, "pqrs".toCharArray());
        dict.put(8, "tuv".toCharArray());
        dict.put(9, "wxyz".toCharArray());


        letterCombinationsHelper(0, digits, ans, dict, "");
        return ans;
    }

    private void letterCombinationsHelper(int idx, String digits, List<String> ans, Map<Integer, char[]> dict, String current) {
        if (idx == digits.length()) {
            ans.add(current);
            return;
        }

        char[] arr = dict.get(Integer.parseInt(String.valueOf(digits.charAt(idx))));
        for (char c : arr) {
            current = current + c;
            letterCombinationsHelper(idx + 1, digits, ans, dict, current);
            current = current.substring(0, current.length() - 1);
        }

    }
}
