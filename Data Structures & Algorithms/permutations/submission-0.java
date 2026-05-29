class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permuteHelper(0, new ArrayList<>(), nums, ans, new HashSet<>());
        return ans;
    }

    private void permuteHelper(int idx, List<Integer> current, int[] nums, List<List<Integer>> ans, Set<Integer> visited) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!visited.contains(nums[i])){
                visited.add(nums[i]);
                current.add(nums[i]);
                permuteHelper(idx + 1, current, nums, ans, visited);
                current.remove(current.size() - 1);
                visited.remove(nums[i]);
            }

        }


    }
}
