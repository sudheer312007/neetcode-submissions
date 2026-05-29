class Solution {
  public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsetsHelper(0, new ArrayList<>(), ans, nums);
        return ans;

    }

    private void subsetsHelper(int idx, List<Integer> current, List<List<Integer>> ans, int[] nums) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        subsetsHelper(idx + 1, current, ans, nums);
        current.add(nums[idx]);
        subsetsHelper(idx+1, current, ans, nums);
        current.remove(current.size()-1);

    }
}
