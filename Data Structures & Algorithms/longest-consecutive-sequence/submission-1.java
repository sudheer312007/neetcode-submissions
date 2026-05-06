class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int num:nums){
            set.add(num);
        }
        int ans = 0;

        for(int num:nums){
            if(!set.contains(num-1)){
                int temp = num+1;
                int streak = 1;
                while (set.contains(temp)){
                    temp++;
                    streak++;
                }
                ans = Math.max(ans,streak);


            }
        }
        return ans;
    }
}
