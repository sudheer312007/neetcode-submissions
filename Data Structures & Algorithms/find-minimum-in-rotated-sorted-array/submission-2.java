class Solution {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length-1;
        int ans = Integer.MAX_VALUE;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[start] < nums[end]){
                ans = Math.min(ans, nums[start]);
            }
            ans = Math.min(ans, nums[mid]);
            if( nums[start] <= nums[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return ans;
        
    }
}
