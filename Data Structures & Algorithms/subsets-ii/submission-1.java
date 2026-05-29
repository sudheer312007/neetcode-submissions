class Solution {
   public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupHelper(0, new ArrayList<>(), nums, ans);
        return ans;
    }

    private void subsetsWithDupHelper(int idx, List<Integer> current, int[] nums, List<List<Integer>> ans) {
        if (idx <= nums.length) {
            ans.add(new ArrayList<>(current));
        }

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            subsetsWithDupHelper(i + 1, current, nums, ans);
            current.remove(current.size() - 1);
        }


    }
}
