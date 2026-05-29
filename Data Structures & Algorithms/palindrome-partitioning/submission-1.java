class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        paritionHelper(0, 0, s, ans, new ArrayList<String>());
        return ans;
    }

    private void paritionHelper(int start, int end, String str, List<List<String>> ans, List<String> current) {
        if (end == str.length()) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (isPalindrome(str, start, end)) {
            current.add(str.substring(start, end + 1));
            paritionHelper(end + 1, end + 1, str, ans, current);
            current.remove(current.size() - 1);
        }
        if (end < str.length() - 1)
            paritionHelper(start, end + 1, str, ans, current);
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else return false;
        }
        return true;
    }
}
