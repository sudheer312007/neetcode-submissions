class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();

        int i=0, j=0;
        int[] ans = new int[nums.length-k+1];
        int ai = 0;
        while(j< nums.length){
            while(!dq.isEmpty() && dq.peekLast() < nums[j]){
                dq.pollLast();
            }
            dq.offerLast(nums[j]);

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                ans[ai] = dq.peekFirst();
                if(dq.peekFirst() == nums[i]){
                    dq.pollFirst();
                }
                i++;
                j++;
                ai++;
            }
        }

        return ans;
    }

}
