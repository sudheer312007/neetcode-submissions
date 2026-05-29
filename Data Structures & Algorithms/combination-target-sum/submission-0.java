class Solution {
   public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationSumHelper(0, nums, target, new ArrayList<>(), ans);
        return ans;
    }

    private void combinationSumHelper(int idx, int[] nums, int target, List<Integer> current, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }

        while (idx < nums.length) {
            current.add(nums[idx]);
            combinationSumHelper(idx, nums, target - nums[idx], current, ans);
            current.remove(current.size() - 1);
            idx++;
        }
    }
}
