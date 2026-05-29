class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesisHelper(0, n, n, ans, "");
        return ans;
    }

    private void generateParenthesisHelper(int idx, int openRemaining, int closeRemaining, List<String> ans, String current) {
        if (openRemaining == 0 && closeRemaining == 0) {
            ans.add(current);
            return;
        }
        if (openRemaining < closeRemaining && closeRemaining > 0) {
            generateParenthesisHelper(idx + 1, openRemaining, closeRemaining - 1, ans, current + ")");
        }

        if(openRemaining > 0){
            generateParenthesisHelper(idx + 1, openRemaining - 1, closeRemaining, ans, current + "(");
        }

    }
}
