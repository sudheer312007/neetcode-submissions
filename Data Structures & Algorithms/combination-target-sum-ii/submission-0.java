class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Helper(0, candidates, ans, new ArrayList<>(), target);
        return ans;
    }

    private void combinationSum2Helper(int idx, int[] candidates, List<List<Integer>> ans, List<Integer> current, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            if (target >= candidates[i]) {
                current.add(candidates[i]);
                combinationSum2Helper(i + 1, candidates, ans, current, target - candidates[i]);
                current.remove(current.size() - 1);
            }
        }

    }


}
