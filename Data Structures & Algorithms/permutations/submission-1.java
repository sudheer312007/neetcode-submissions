class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permuteHelper(0, nums, ans);
        return ans;
    }

    private void permuteHelper(int idx, int[] nums, List<List<Integer>> ans) {
        if (idx == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (Integer num : nums) {
                temp.add(num);
            }
            ans.add(temp);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            permuteHelper(idx + 1, nums, ans);
            swap(nums, idx, i);
        }


    }

    private void swap(int[] nums, int idx, int i) {
        int temp = nums[idx];
        nums[idx] = nums[i];
        nums[i] = temp;
    }
}
